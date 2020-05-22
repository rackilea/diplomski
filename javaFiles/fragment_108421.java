runOnUiThread(new Runnable() {
    public void run() {
        final StringBuilder sb = ... ;
        final TextView tv = ... ;

        tv.setText(sb.toString());
    }
});