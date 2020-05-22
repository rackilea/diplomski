TextView longi;
TextView lat;
TextView tv;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.get_cords);
    tv=(TextView) findViewById(R.id.tv);
    longi=(TextView) findViewById(R.id.longi);
    lat=(TextView) findViewById(R.id.lat);