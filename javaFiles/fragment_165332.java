public class Test extends AppCompatActivity {
Button b1;
TextView t1,t2;
EditText e1;
int a,b;
@Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
     b1 = (Button) findViewById(R.id.button2);
     t1=(TextView) findViewById(R.id.textView4);
     t2=(TextView) findViewById(R.id.textView5);
     e1=(EditText) findViewById(R.id.editText);
    Random r = new Random();
    int i = r.nextInt(10 - 2) + 2;
    t1.setText(i +"");
    Random r1 = new Random();
    int j = r1.nextInt((9 - 2) + 1) + 2;
    t2.setText(j +"");

     a = Integer.parseInt(t1.getText().toString());
     b = Integer.parseInt(t2.getText().toString());

  b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int result =  a*b;
            String str = String.valueOf(result);

            String c = e1.getText().toString();

            if(TextUtils.isEmpty(c)) {
                e1.setError("Please enter your answer");
                return;
            }

            if(c.equals(str)){
                Toast.makeText(Test.this, "Alright",Toast.LENGTH_LONG).show();

            }

            else{
                Toast.makeText(Test.this, "wrong",Toast.LENGTH_LONG).show();
            }

            e1.setText("");
        }

    });
}}