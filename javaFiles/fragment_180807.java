@Override
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
//initialize views here 
EditText mEdit = (EditText)findViewById(R.id.editText1);
TextView myTextView = (TextView) findViewById(R.id.label);
Button yourButton=(Button)findViewByid(R.id.youridforbutton);
//set onclicklistener for your button
 yourbutton.setOnClickListener(
  new View.OnClickListener() {
  @Override
  public void onClick(View v) {
number = mEdit.getText().toString();
number2 = Integer.parseInt(number);

if(F=true){
output=number2*9/5+32;
}
else{
output=number2-32*5/9;
}

myTextView.setText(""+output);
}
});

}