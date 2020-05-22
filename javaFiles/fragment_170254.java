private EditText firtsNumberEditText,secondNumberEditText;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method

        Button addButton = (Button)findViewById(R.id.Addbutton);
        firtsNumberEditText = (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText = (EditText) findViewById(R.id.secondNumberEditText);
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() {    
            @Override
            public void onClick(View v) {

                int n1, n2;

                if (firtsNumberEditText.getText().toString().isEmpty() || firtsNumberEditText.getText().toString() == "")
                    n1 = 0;
                else n1 = Integer.parseInt(firtsNumberEditText.getText().toString());

                if (secondNumberEditText.getText().toString().isEmpty() || secondNumberEditText.getText().toString() == "")
                    n2 = 0;
                else n2 = Integer.parseInt(secondNumberEditText.getText().toString());

                int result = n1 + n2;

                resultTextView.setText(result +"");
            }

        });

    }