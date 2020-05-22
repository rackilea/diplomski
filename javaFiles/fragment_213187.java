@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);    
    new DownloadTask().downloadTask.execute("https://www.google.com");
}