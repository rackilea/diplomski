/**
     * Very useful for loading a ChatRoom that already has messages loaded from the bottom of this
     * table. It allows to 'load more' messages(just the number needed) without loading the
     * whole ChatRoom.
     * @param numOfMessagesGottenAlready The number of messages that the room has already.
     * @param numOfMessagesNeeded The number of messages to load more.
     * @return an ArrayList of messages loaded in pagination style..from the bottom this time.
     */
    public ArrayList<Post> getRecentPosts(int numOfMessagesGottenAlready,int numOfMessagesNeeded) {
        SQLiteDatabase db = this.getReadableDatabase();
        int add = numOfMessagesGottenAlready + numOfMessagesNeeded;


        boolean success = true;
        try {
            db.beginTransaction();

            Cursor res = db.rawQuery("select COUNT(*) from "+ROOM_TABLE_NAME , null);
            res.moveToFirst();

            int count = res.getInt(0);
            if (!res.isClosed()) {
                res.close();
            }

            Log.e("table row count", count + "");

            Log.e("add", add + "");

            if(count >= numOfMessagesGottenAlready) {
                Cursor set = db.rawQuery("select * from " + ROOM_TABLE_NAME + " ORDER BY " + ROOMS_COLUMN_ID +
                        " ASC LIMIT " + numOfMessagesNeeded +
                        " OFFSET ( " + (count - add) + " )"
                        , null);
set.moveToFirst();
                ArrayList<Post>posts = new ArrayList<>();
                try {
                    while (!set.isAfterLast()) {
                        posts.add(Post.parseJsonToPost(
                                set.getString(set.getColumnIndex(ROOMS_COLUMN_JSON))));
                        set.moveToNext();
                    }
                }
                catch (Exception e){return posts;}
                if (!set.isClosed()) {
                    set.close();
                }
                return posts;
            }

            db.setTransactionSuccessful();
            success = true;
        }
        catch (SQLiteException e){
            e.printStackTrace();
            success = false;
        }
        finally {
            db.endTransaction();
        }

return new ArrayList<Post>();
    }