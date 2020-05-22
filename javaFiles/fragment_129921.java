// try this way (here i'm declare your both view object as globaly for your class so it can be acccess any where in classs and is created onCreate() at first time and further it used directly)
private long mode;
private Button playBtn; 
private TextView aboutTitle;

@Override 
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
playBtn = (Button)findViewById(R.id.playBtn);
aboutTitle = (TextView)findViewById(R.id.aboutTitle);
playBtn.setTypeface(robotoThin);
aboutTitle.setText("hello world");
}