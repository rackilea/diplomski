private ScrollView scrollView;
private TextView tvabove;
private TextView tv;
....
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dragpanel);
    scrollView = (ScrollView)findViewById(R.id.scrollatherosclerosis);
    tv = (TextView)findViewById(R.id.Signandsymptompsid);
    tvabove = (TextView)findViewById(R.id.Signandsymptomsparagraph);
    ...
}