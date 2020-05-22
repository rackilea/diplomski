if(cursor != null && cursor.getCount >0){
    while(cursor.moveToNext()){
        //create new song item and add the album information you need
        Song album = new Song(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)),
           cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));             

            album.setAlbumId(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)));
            album.setAlbumId(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)));

        //add the Song item to the global arraylist
        Albums.add(album)
    }
}

cursor.close();