private Handler handler;

@Override
public void onCreate(Bundle savedInstanceState) {
  handler = new Handler();
}

private void killGame() {
  if(!bc.BarThread.isInterrupted()){
    bc.BarThread.interrupt();
  }

  handler.post(new Runnable() {
    @Override
    public void run() {
      gameLayout.removeAllViewsInLayout();

      RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        LayoutParams.WRAP_CONTENT,
        LayoutParams.WRAP_CONTENT
      );
      TextView tv = new TextView(MainActivity.this);

      gameLayout.addView(tv, params);
      tv.setText("Game Over");
    }
  });
}