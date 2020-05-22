public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_second);

myInnerLayoutOne = (LinearLayout) findViewById(R.id.rl_1); 

myText = (EditText) myInnerLayoutOne.findViewById(R.id.age_edit_text);

...}