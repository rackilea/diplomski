public class MainActivity extends Activity {

EditText quantity;
Button plus,minus;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    plus = (Button) findViewById(R.id.button1);
    minus = (Button) findViewById(R.id.button2);

    quantity = (EditText) findViewById(R.id.qty);

    plus.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            String numb = quantity.getText().toString();
            int num1 = Integer.parseInt(numb);
            int inum = num1+1;
            quantity.setText(Integer.toString(inum));
        }
    });

 minus.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            String numb = quantity.getText().toString();
            int num1 = Integer.parseInt(numb);
            int inum = num1-1;
            quantity.setText(Integer.toString(inum));
        }
    });
  } 
}