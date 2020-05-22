public class MainActivity extends AppCompatActivity {


   TextView totalBill;
   TextView totalTip;
   TextView totalPerPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView checkAmount = (TextView) findViewById(R.id.textView);
        TextView noOfPeople = (TextView) findViewById(R.id.textView2);
        TextView tipPercent = (TextView) findViewById(R.id.textView3);

        totalBill = (TextView) findViewById(R.id.textView7);
        totalTip = (TextView) findViewById(R.id.textView6);
        totalPerPerson = (TextView) findViewById(R.id.textView5);
        TextView tipPerPerson = (TextView) findViewById(R.id.textView4);


        Button calculateButton = (Button) findViewById(R.id.button);

       calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try { 
                   int amount = Integer.parseInt(checkAmount.getText().toString());
                   int people = Integer.parseInt(noOfPeople.getText().toString());
                   int tip = Integer.parseInt(tipPercent.getText().toString());

                    totalBill.setText(new StringBuilder().append(amount).append(tip / 100 * amount).toString());
                    totalTip.setText(String.valueOf(tip / 100 * amount));
                    // totalPerPerson.setText(totalBill.get/people);
                } catch (NumberFormatException ex) {
                  System.out.print("Not a number");
                }
            }
        });

    }
}