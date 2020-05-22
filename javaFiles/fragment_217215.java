btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        int myNum_one, myNum_two, myNum_three;

        try {

            myNum_one = Integer.parseInt(editText1.getText().toString());
            myNum_two = Integer.parseInt(editText2.getText().toString());

            String s = "Sum of entered number is: %d \n multiply of entered number is: %d \n subtraction of entered number is: %d";
            int sum = myNum_one + myNum_two;
            int multiply = myNum_one * myNum_two;
            int subtraction = myNum_one - myNum_two;
            alertDialogBuilder.setTitle("Detailed Output is");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setMessage(String.format(s, sum, multiply, subtraction))
                  .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } catch(NumberFormatException nfe) {
            Log.d("TAG","Could not parse " + nfe);
        } 

    }
});