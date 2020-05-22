protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstNum = (EditText) findViewById(R.id.FirstNum);
        SecondNum = (EditText) findViewById(R.id.SecondNum);
        Result = (TextView) findViewById(R.id.Result);
        PlusButton = (Button) findViewById(R.id.PlusButton);

        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValid=true;
                if(FirstNum.getText().toString().trim().length()<=0){
                    FirstNum.setError("Value Required");
                    isValid=false;
                }
                if(SecondNum.getText().toString().trim().length()<=0){
                    SecondNum.setError("Value Required");
                    isValid=false;
                }
                if(isValid){
                    Result.setText(String.valueOf(plusmethod(Integer.parseInt(FirstNum.getText().toString()),Integer.parseInt(SecondNum.getText().toString()))));
                }

            }
        });
    }