public void onRadioButtonClicked(final View view) {
    final boolean checked = ((RadioButton) view).isChecked();
    final EditText editTextUser = findViewById(R.id.editTextUser);
    final TextView textViewOuput = findViewById(R.id.textViewOutput);


    zar = findViewById(R.id.radioButtonZar);
    neo = findViewById(R.id.radioButtonNeo);

    Button btn = findViewById(R.id.buttonConvert);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NumberFormat nm = NumberFormat.getNumberInstance();
            final Double userInput = Double.parseDouble(editTextUser.getText().toString());
            switch(view.getId()) {
                case R.id.radioButtonZar:
                    if(checked)
                        zarAmount = (userInput * 833.44);
                    textViewOuput.setText(nm.format(zarAmount));

                    break;
                case R.id.radioButtonNeo:
                    if(checked)
                        neoAmount = (userInput / 0.001199);
                    textViewOuput.setText(nm.format(neoAmount));
                    break;

            }
        }
    });
}