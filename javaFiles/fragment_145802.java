public class MainActivity extends AppCompatActivity {

    EditText et_input, et_output, et_number;
    Button b_go;

    String text ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input = (EditText) findViewById(R.id.et_input);
        et_output = (EditText) findViewById(R.id.et_output);
        et_number = (EditText) findViewById(R.id.et_number);
        b_go = (Button) findViewById(R.id.b_go);

        b_go.setOnClickListener(new View.OnClickListener() { //you had an extra bracket here
            @Override

            public void onClick(View v){
                String input = et_input.getText().toString();
                int number = Integer.parseInt(et_number.getText().toString());

                for (int i=0; i < number; i++){
                    text = text + input + " ";
                }
                et_output.setText(text);
            }
        });
    }
}