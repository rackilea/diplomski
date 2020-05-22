public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText caloriesIn = (EditText) findViewById(R.id.caloriesIn);
                EditText fatIn = (EditText) findViewById(R.id.fatIn);
                TextView caloriesOut = (TextView) findViewById(R.id.caloriesOut);
                TextView fatOut = (TextView) findViewById(R.id.fatOut);
                String caloriesString = caloriesIn.getText().toString();
                int calories = 0;
                if (isParsable(caloriesString)){
                    calories = Integer.parseInt(caloriesString);
                    int caloriesResult = calories;
                    caloriesOut.setText(caloriesResult + "");
                }

                String fatString = caloriesIn.getText().toString();
                int fat = 0;
                if (isParsable(fatString)){
                    fat = Integer.parseInt(fatString);
                    int fatResult = fat;
                    fatOut.setText(fatResult + "");
                }

            }
        });

    }


    public static boolean isParsable(String input){
        boolean parsable = true;
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            parsable = false;
        }
        return parsable;
    }

}