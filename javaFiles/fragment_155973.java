runOnUiThread(new Runnable() {
     @Override
     public void run() {

        greenSquare.setVisibility(View.INVISIBLE);
        greenBigSquare.setVisibility(View.VISIBLE);

    }
});