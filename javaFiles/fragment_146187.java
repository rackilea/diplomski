final TextView yourText = (TextView) findViewById(R.id.yourTextId);
Handler handler = new Handler();
handler.postDelayed(new Runnable()) {
@Override
    public void run() {
        yourText.setVisibility(View.VISIBLE);
    }
}, 7000);