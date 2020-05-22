@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
addListenerOnButton();

public void addListenerOnButton() {
final Context context = this;
submit_btn = (Button) findViewById(R.id.submit_btn);

submit_btn.setOnClickListener(new OnClickListener() {
@Override
        public void onClick(View arg0) {
       if (radioGroup.getCheckedRadioButtonId() == -1)
 {
 Toast.makeText(context, "Select an option.", Toast.LENGTH_LONG).show();
 }
 else{
            Intent intent = new Intent(context, ViceChairperson.class);
            startActivity(intent);
            finish();

        }
 }
 });

}
}