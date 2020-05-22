SlideOutMenu root;
View container;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
container = getLayoutInflater().inflate(R.layout.activity_main, null);
root = (SlideOutMenu) container.findViewById(R.id.mainActivitySlideout);
 this.setContentView(container);
//the following codes can follow