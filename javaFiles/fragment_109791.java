ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        imageView = (ImageView)findViewById(R.id.imgView);
        new DownloadFilesTask().execute();       
    }