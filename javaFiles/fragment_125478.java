public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      videopath=new ArrayList<String>();
      File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/bluetooth/");
      File[] files = path.listFiles();
      for( File f : files ){


                  String absPath = f.getAbsolutePath();
                  videopath.add(absPath);


      }

      setListAdapter(new MyThumbnaildapter(AndroidThumbnailList.this, R.layout.row, videopath));
  }