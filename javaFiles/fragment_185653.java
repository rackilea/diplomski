b1.setVisibility(View.INVISIBLE);
b1.postDelayed(new Runnable() {
    @Override
    public void run() {
        b1.setVisibility(View.VISIBLE);
    }
}, 3000);