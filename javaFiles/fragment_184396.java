Button myButton = (Button) findViewById(R.id.plus);
    TextView myTexView = (TextView)findViewById(R.id.pluson);
    myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  int value = Integer.valueOf(myTextView.getText().toString());
                  myTextView.setText(String.valueOf(value++));
                }
            });