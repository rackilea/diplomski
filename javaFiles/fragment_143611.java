public void onFinish() {
    mTextField.setText("Time is up");
    timerProcessing = false;
    //Intent intent = new Intent(TestActivity.this, Assesment.class);
    //startActivity(intent);


  AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(TestActivity.this).create();
        alertDialog.setTitle("Score");
        alertDialog.setMessage((score) +" out of " + (QuizFunActivity.getQuesList().length()));

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Retake", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                review = false;
                quesIndex=0;
                TestActivity.this.showQuestion(0, review);
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Review", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                review = true;
                quesIndex=0;
                TestActivity.this.showQuestion(0, review);
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"Quit", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which) {
                review = false;
                finish();
            }
        });

        alertDialog.show();

    }


}