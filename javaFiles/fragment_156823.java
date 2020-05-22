public void hide(){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            mAdView.setVisibility(View.GONE);
        }
    });
}

public void show(){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            mAdView.setVisibility(View.VISIBLE);
        }
    });
}