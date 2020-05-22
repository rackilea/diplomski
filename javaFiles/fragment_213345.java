public class MainActivity extends AppCompatActivity {
    //Declare the obj1 object here
    Class1 obj1;

   @Override
   public void onCreate(Bundle savedInstanceState) {
       //inflate layout and do other stuff

       //from where you posted
       obj1 = new Class1();
       Button button1 = (Button) findViewById(R.id.button1);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               obj1.ownedAdd(10);
           }
       }); 
   }
}