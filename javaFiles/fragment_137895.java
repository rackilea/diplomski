...
public void onCreate(Bundle b){
super(b);
setContentView(R.layout.your_activity_layout);
...

View yourView = getLayoutInflater().inflate(R.layout.your_xml_file, null);
yourBasicLayout.addView(yourView);
...
}