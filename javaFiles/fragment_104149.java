private int i = 0; // Does the trick!
public void startLoop(View view) {
    String string = getString(R.string.hello);
    ((TextView)findViewById(R.id.hello)).setText("starting...");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i < 10) {
                    String updated = Integer.toString(i);
                    i++;
                    updateHelloOnUiThread(updated);
                } else {
                    updateHelloOnUiThread("done!");
                    handler.removeCallbacksAndMessages(null);
                    i = 0; // For future usages
                }
            }
        },250);
}

private void updateHelloOnUiThread(final String text) {
     MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView)findViewById(R.id.hello)).setText(text);
            }
     });
}