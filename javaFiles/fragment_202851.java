main_activity.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        hours.setText("0" + hours.getText().toString());
    }
});