SharedPreferences data = getSharedPreferences(filename, 0);

AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
    myAlert.setTitle("You have lost");
    myAlert.setMessage("Your score was :" + score + "\n" + "Your Highscore is :" + data.getInt("Hscore", 0)) // refer syntax
            .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
            public void onClick(DialogInterface dialog, int which){
                    dialog.dismiss();
                    score=0;
                    TextView myScore = (TextView)findViewById(R.id.scoreTxt);
                    String points = String.valueOf(score);
                    myScore.setText(points);
                }
            })
            .create();