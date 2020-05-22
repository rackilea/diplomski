public List<Video> ListResult;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Update view

        setContentView(R.layout.videos);

        ListResult= new ArrayList<Video>();  //<< initialize List here