...
runOnUiThread(new Runnable() {
    @Override 
    public void run() {
        // Do all your view updates in here
        textView.setText("string");
    }
});
....