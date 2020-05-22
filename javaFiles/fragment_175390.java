EditText user_num;
TextView reply;
Button btnsbm;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    user_num = (EditText)findViewById(R.id.editText);
    reply  = (TextView)findViewById(R.id.textView);
    btnsbm = (Button)findViewById(R.id.button);
    onclicklistener();
}