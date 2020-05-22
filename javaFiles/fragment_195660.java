public class Current extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_name);
    // Show the Up button in the action bar.
    setupActionBar();


  Button calc1 = (Button)findViewById(R.id.buttons_id_in_layout);

    calc1.setOnClickListener(new View.OnClickListener() {


         public void onClick(View v) {

            EditText Charge1 = (EditText)findViewById(R.id.number_input_2);    
            EditText Time1 = (EditText)findViewById(R.id.number_input_3);
            TextView Distances_answer = (TextView)findViewById(R.id.distances_answer);
            double charge = Double.parseDouble(Charge1.getText().toString());
            double time = Double.parseDouble(Time1.getText().toString());
//Time is a class in Java
            Distances_answer.setText("" +charge*time);

        }
    });
}