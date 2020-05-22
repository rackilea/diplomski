runOnUiThread(new Runnable() {
    @Override
    public void run() {
        count.setText(String.valueOf(occ));
    }
});