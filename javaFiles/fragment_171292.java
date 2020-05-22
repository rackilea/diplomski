public class MyActivity extends Activity {
     //your counter variable
     int counter = 0;
     protected void onCreate(Bundle icicle) {
         super.onCreate(icicle);

         setContentView(R.layout.my_layout);

         final TextView textView = (TextView) findViewById(R.id.textView);
         final Button button = (Button) findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                  counter = 0;
                  textView.setText(counter+"");
             }
         });
     }
 }