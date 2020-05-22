@Override
public void onTick(long millisUntilFinished) {
  long millis = millisUntilFinished;
  String hms = String.format("%02d:%02d:%02d",
      TimeUnit.MILLISECONDS.toHours(millis),
      TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
      TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
  System.out.print(hms);
  CountdownTimer.setText(hms);
}