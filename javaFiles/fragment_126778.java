StringBuilder proContainer;
List <String> proStrings = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    bButton = (Button) findViewById(R.id.bButton);
    tvOutput = (TextView) findViewById(R.id.tvOutputTxt);
    etInput = (EditText) findViewById(R.id.etInput);
proContainer=new StringBuilder();
    bButton.setOnClickListener(this);

}

@Override
public void onClick(View v) {
    switch(v.getId()){
        case R.id.bButton:
            proStrings.add(etInput.getText().toString());
         for (int i = 0; i < proStrings.size(); i++){
           proContainer.append(proStrings.get(i));
         }
            tvOutput.setText(proContainer.toString());
            break;

    }
  }