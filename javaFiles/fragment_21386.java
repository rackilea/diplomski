@Override
public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    textview = new TextView(this); // << This used to be a local var, thats why NPE
    textview.setText(builde.toString());
    setContentView(textview);
}