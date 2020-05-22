//Show your view
yazi.setVisibility(View.VISIBLE);

Handler handler = new Handler();
handler.postDelayed(new Runnable() {

    @Override
    public void run() {
        // Hide your View after 3 seconds
        yazi.setVisibility(View.GONE);
    }
}, 3000);