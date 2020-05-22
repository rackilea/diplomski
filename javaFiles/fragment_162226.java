private Handler mHandler;
private int 

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mHandler = new Handler();
    mHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            computerTurnDown(); 
        }
    }, 500); //Delay time in ms
    ...
}

private void computerTurnDown(){
      final int val = random.nextInt(4);

            if (!mOverlay.isShown()) {
                //Computer shows sequence
                switch (val) {
                    case 0:
                        mTopLeft.getBackground().setColorFilter(GREEN_DOWN, PorterDuff.Mode.MULTIPLY);
                        System.out.println(val);
                        break;
                    case 1:
                        mTopRight.getBackground().setColorFilter(RED_DOWN, PorterDuff.Mode.MULTIPLY);
                        System.out.println(val);
                        break;
                    case 2:
                        mBotLeft.getBackground().setColorFilter(YELLOW_DOWN, PorterDuff.Mode.MULTIPLY);
                        System.out.println(val);
                        break;
                    case 3:
                        mBotRight.getBackground().setColorFilter(BLUE_DOWN, PorterDuff.Mode.MULTIPLY);
                        System.out.println(val);
                        break;
                    default:
                        break;
                }
                mHandler.postDelayed(new Runnable() {
                      @Override
                      public void run() {
                            computerTurnUp(val); 
                      }
                }, 500);
}

private void computerTurnUp(){
     switch (val) {
                    case 0:
                        mTopLeft.getBackground().setColorFilter(GREEN_UP, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 1:
                        mTopRight.getBackground().setColorFilter(RED_UP, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 2:
                        mBotLeft.getBackground().setColorFilter(YELLOW_UP, PorterDuff.Mode.MULTIPLY);
                        break;
                    case 3:
                        mBotRight.getBackground().setColorFilter(BLUE_UP, PorterDuff.Mode.MULTIPLY);
                        break;
                    default:
                        break;
                }
                compSeq.add(val);
                if (compSeq.size() < level){
                       mHandler.postDelayed(new Runnable() {
                           @Override
                           public void run() {
                                computerTurnDown(); 
                           }
                      }, 300);
                }else{
                     isPlayerTurn = true;
                }

}