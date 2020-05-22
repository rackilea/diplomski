Handler handler = new Handler();
Runnable turnBlack = new Runnable(){

    @Override
    public void run() {
        myView.setBackgroundColor(Color.BLACK);
        goWhite();
    }};

    Runnable turnWhite = new Runnable(){

        @Override
        public void run() {
            myView.setBackgroundColor(Color.White);
            goBlack();
        }};

public void goBlack() {
    handler.postDelayed(turnBlack, 500);
}

public void goWhite() {
    handler.postDelayed(turnWhite, 2000);
}