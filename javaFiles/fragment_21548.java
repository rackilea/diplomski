button.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
    String a = editText.getText().toString();
    String b = editText2.getText().toString();

   Intent intent = new Intent(your_activity.this, Activity2.class);
   intent.putExtra("a_value", a);
   intent.putExtra("b_value", b);
   startActivity(intent);
 }
});