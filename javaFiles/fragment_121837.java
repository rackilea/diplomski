public class MyActivity extends AppCompatActivity{
    private EditText editText1, editText2, editText3, editText4;
    private Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        //javaVariable = (Cast type) findViewById(R.id.IdFromXML);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        btn_reset = (Button) findViewById(R.id.btn_reset);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Here's the actions to do when btn_reset is clicked
                 editText1.setText("");
                 editText2.setText("");
                 editText3.setText("");
                 editText4.setText("");
            }
        });
    }
}