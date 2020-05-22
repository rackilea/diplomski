static synchronized public void firstRollSP( ) throws InterruptedException {

    mGame.mDice.setDie1( mGame.mDiceFirstRoll.getDie1( ) );

    mGame.mDice.setRolled( true );

    MainActivity.activity.pushTextGreen( Strings.get_First_roll_X_Die1( ) );
    new Handler().postDelay(new Runnable(){
       //your code here.
    },2000 );

}