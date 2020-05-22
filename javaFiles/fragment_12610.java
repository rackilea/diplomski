@Override
public void onTick(long millisUntilFinished) {
    i++;
    long secondsInMilli = 1000;
    long minutesInMilli = secondsInMilli * 60;
    long hoursInMilli = minutesInMilli * 60;
    long tempMili = millisUntilFinished;

    long elapsedHours = tempMili / hoursInMilli;
    tempMili = tempMili % hoursInMilli;

    long elapsedMinutes = tempMili / minutesInMilli;
    tempMili = tempMili % minutesInMilli;

    long elapsedSeconds = tempMili / secondsInMilli;

    String yy = String.format("%02d:%02d:%02d", elapsedHours, elapsedMinutes, elapsedSeconds);
    textView.setText(yy);

    progressbar.setProgress((int) i * 100 / (duration / (int) secondsInMilli));
    remainingDuration = (duration/ 1000) - (millisUntilFinished/1000);
}