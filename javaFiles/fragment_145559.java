ImageView img;
img=(ImageView)findViewById(R.id.imgview);
CountDownTimer timer = new CountDownTimer(1000, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
    }

    @Override
    public void onFinish() {
img.setVisibility(View.GONE);

            }
};
timer.start();