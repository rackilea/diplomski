Handler handler1 = new Handler();
Handler handler2 = new Handler();
handler1.postDelayed(new Runnable() {
    tvt1.setVisibility(View.VISIBLE);
}, 7000);
handler2.postDelayed(new Runnable() {
    tvt2.setVisibility(View.VISIBLE);
}, 12000);