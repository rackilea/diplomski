public class Buttons extends Activity {

protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);

   Button btn1 = (Button) findViewById(R.id.button1);
   Button btn2 = (Button) findViewById(R.id.button3);  // did you mean R.id.button2?

   // Create the onClickListener for btn1
   btn1.setOnClickListener(new View.OnClickListener() {

       public void onClick(View v) {
           Intent ScrollViewTest = new Intent(this, ScrollViewTest.class);
           startActivity(ScrollViewTest);
       }
   });

   // Create the onClickListener for btn2
   btn2.setOnClickListener(new View.OnClickListener() {

       public void onClick(View v) {
           Intent ScrollViewTest = new Intent(this, CameraTest.class);
           startActivity(CameraTest);
       }
   });
}