public void generateH(View v){
    Random rand = new Random();
    int number = rand.nextInt(2)+1;
    TextView myText = (TextView)findViewById(R.id.coinResult);

    if (number == 1){
        myText.setText("HEADS");
        TextView myScore = (TextView)findViewById(R.id.scoreTxt);
        score = score+1;
        String points = String.valueOf(score);
        myScore.setText(points);
        if(highScore>points)
        {
            // This will store the new high score in the sharedpreferences.
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("Hscore", highScore);
            editor.commit(); // Use editor.apply() for saving in background
            // after this highscore will be 100
        }else
        {
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("Hscore", points);
            editor.commit();
        }

    }

    else{
        myText.setText("TAILS");
        score = 0;
        TextView myScore = (TextView) findViewById(R.id.scoreTxt);
        String points = String.valueOf(score);
        myScore.setText(points);
        if(highScore>points)
        {
            // This will store the new high score in the sharedpreferences.
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("Hscore", highScore);
            editor.commit(); // Use editor.apply() for saving in background
            // after this highscore will be 100
        }else
        {
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("Hscore", points);
            editor.commit();
        }

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("You have lost");
        myAlert.setMessage("Your score was :" + score + "\n" + "Your Highscore is: " +  data.getInt("Hscore", 0) )
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        })
        .create();

        myAlert.show();
    }

}