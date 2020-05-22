@SuppressWarnings("deprecation")
        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            ArrayList<Boolean> killList=CustomCursorAdapter.hitList;
            int totalDeleted=0;
            for(int i=0;i<killList.size();i++)
            {
                //Log.d(TAG,i+":"+killList.get(i));
                c.moveToPosition(i);
                String title=c.getString(c.getColumnIndex(ItemDB.TITLE));
                int _id=c.getInt(c.getColumnIndex(ItemDB._ID));
                //Log.d(TAG, "Item has title "+title+" and id "+_id );
                int rowsAffected=0;
                if(killList.get(i))
                {
                    rowsAffected=db.delete(_id);
                    //Log.d(TAG, "Deleted row with id "+_id);
                    killList.set(i, false);

                }
                totalDeleted+=rowsAffected;

            }
            //Log.d(TAG, "The total number of rows deleted "+totalDeleted);
            //if(c.requery())
            //{
                //Log.d(TAG, "Requerying data,this calls notifyDataSetChanged");
            //}

        }});