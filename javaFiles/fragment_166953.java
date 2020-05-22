String[] proj = { MediaStore.Audio.Media._ID,
                  MediaStore.Audio.Media.DATA,
                  MediaStore.Audio.Media.DISPLAY_NAME,
                  MediaStore.Audio.Artists.ARTIST };
Cursor tempCursor = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                                 proj,
                                 null,
                                 null,
                                 null);

int col_index=-1;
int numSongs=tempCursor.getCount();
int currentNum=0;
List<String> songname = new ArrayList<String>();
while (tempCursor.moveToNext())
    col_index = tempCursor.getColumnIndexOrThrow(MediaStore.Audio.Artists.ARTIST);

    songname.add(tempCursor.getString()); // here you need the column index number of song title name only
}

ArrayAdapter<String> songss = new ArrayAdapter<String>(this, R.id.songs,songname);
setListAdapter(songss);