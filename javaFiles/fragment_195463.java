RadioButton radioButton1, radioButton2, radioButton3;
Button setColorButton, cancelButton;
TextView textwju;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.radiobutton_example);


    radioButton1   = (RadioButton) findViewById(R.id.czerwonyguzik);
    radioButton2   = (RadioButton) findViewById(R.id.bialyguzik);
    radioButton3   = (RadioButton) findViewById(R.id.niebieskiguzik);
    setColorButton = (Button) findViewById(R.id.setcolor);
    cancelButton = (Button) findViewById(R.id.cancel);
    textwju        = (TextView) findViewById(R.id.textwju);



    setColorButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(radioButton1.isChecked()) {
                textwju.setBackgroundColor(getResources().getColor(R.color.blue));
            } else if(radioButton2.isChecked()) {
                textwju.setBackgroundColor(getResources().getColor(R.color.white));
            } else if(radioButton3.isChecked()) {
                textwju.setBackgroundColor(getResources().getColor(R.color.red));
            }

        }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            radioButton1.setChecked(true);

        }
    });
}