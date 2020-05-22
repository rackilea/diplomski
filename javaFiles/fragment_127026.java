cursor.moveToFirst();
        for (int i = 1; i <= 39; i++) {
            Bitmap bmp = BitmapFactory.decodeFile(cursor.getString(1));
            photos.add(bmp);
            cursor.moveToNext();
            Log.d(TAG, "loop iteration" + i );
        }