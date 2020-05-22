public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final String[] proj = { MediaStore.Video.Media.DATA };
      String folder="bluetooth";
     Cursor cursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            proj, MediaStore.Video.Media.DATA + " like ? ",
            new String[] { "%" + folder + "%" }, null);
     videopath=new ArrayList<String>();
     while (cursor.moveToNext()) {

            videopath.add(cursor.getString(0));
        }
      setListAdapter(new MyThumbnaildapter(AndroidThumbnailList.this, R.layout.row, videopath));
  }
}