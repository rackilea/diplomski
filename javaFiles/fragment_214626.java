public class SampleActivity extends Activity {
    private TextView hourText;
    private TextView minuteText;

    private void updateHourText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hourText.setText(text);
            }
        });
    }

    private void updateMinuteText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                minuteText.setText(text);
            }
        });
    }

    private class ClockTask extends AsyncTask<Void, Void, Void>
    {
        private int hourHand;
        private int minuteHand;


        public ClockTask(int hourHand, int minuteHand) {
            this.hourHand = hourHand;
            this.minuteHand = minuteHand;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                while(minuteHand != 0 || hourHand != 12){
                    if (hourHand != 12){
                        hourHand++;
                        updateHourText(Integer.toString(hourHand));
                        Thread.sleep(250);
                    }
                    if (minuteHand != 0) {
                        minuteHand += 5;
                        minuteHand %= 60;
                        updateMinuteText(Integer.toString(minuteHand));
                        Thread.sleep(250);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}