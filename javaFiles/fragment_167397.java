View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View button) {
            correctIncorrect.setVisibility(View.VISIBLE);
            if (Integer.parseInt(button.getText().toString())==sum) {
                correctIncorrect.setText("Correct");
                correctUpdater();
            }
            else {
                correctIncorrect.setText("Incorrect");
                inCorrectUpdater();
            }
        }
    };

button1.setOnClickListener(myListener);
button2.setOnClickListener(myListener);
button3.setOnClickListener(myListener);
button4.setOnClickListener(myListener);