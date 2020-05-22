public class MainActivity extends AppCompatActivity {


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final EditText ip=(EditText)findViewById(R.id.ip);

    final TextView op=(TextView)findViewById(R.id.op);
    //final String inpt=ip.getText().toString();


    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String inpt=ip.getText().toString();
                InputMethodManager imm=(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                if(inpt==null)op.setText("Please Enter");
                else  if (inpt.equals("a")) op.setText("a entered");
                else if (inpt.equals("b")) op.setText("b entered");

                else op.setText("Unknown keyword");

            }
        });
    }