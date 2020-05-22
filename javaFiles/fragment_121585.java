onCreate(...){
   ...
   setContentView(...);
   //----Example for rock button
   Button Rock = (Button) findViewById(R.id.rock);
   Rock.setOnClickListener(new OnClickListener(){

    @Override
    public void onClick(View v) {
        /* all capitals = user answer */
        if (RPS == 1) {
            startActivity(new Intent(MainActivity.this,Tie.class));
            //ROCK-rock tie
            }
        else if (RPS == 2) {
            //ROCK-paper lose
            startActivity(new Intent(MainActivity.this,Lose.class));
        }
        else if (RPS == 3) {
            //ROCK-scissors win
            startActivity(new Intent(MainActivity.this,Win.class));
        }
        }
    });
    }

//Do the same for other buttons here

}//end of onCreate