if (cursor!=null && cursor.getCount()>0) {
                while (cursor.moveToNext()) {
                    Bitmap bmp = BitmapFactory.decodeFile(cursor.getString(1));
                    photos.add(bmp);
                    Log.d(TAG, "loop iteration" + i );
                }
            }