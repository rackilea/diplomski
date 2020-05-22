private Handler mHandler = new Handler();

ballatack.setImageResource(R.drawable.buttonof);

mHandler.postDelayed(new Runnable() {
    @Override
    public void run() {
        ballatack.setImageResource(R.drawable.buttonof);
    }
}, 5000);