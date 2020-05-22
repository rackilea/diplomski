public class MyActivity extends Activity {
    private boolean activityDestroyed = false;

    @Override
    protected void onDestroy() {
        activityDestroyed = true;
    }

    private void updateData() {
        new Thread() {
            @Override
            public void run() {
                final Data newData = requestData();                     
                if (newData == null) return;                                              

                runOnUiThread(new Runnable() {
                    public void run() {
                        if (activityDestroyed) return;
                        Toast.makeText(MyActivity.this, "Blah",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();
    }
}