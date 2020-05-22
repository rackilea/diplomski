private void startClock() {
    Timeline clock = new Timeline(new KeyFrame(Duration.millis(1000 - Calendar.getInstance().get(Calendar.MILLISECOND)), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            cal = Calendar.getInstance();
            second = cal.get(Calendar.SECOND);
            minute = cal.get(Calendar.MINUTE);
            hour = cal.get(Calendar.HOUR);
            am_pm = (cal.get(Calendar.AM_PM) == 0) ? "AM" : "PM";
            time.setText(String.format("%02d : %02d : %02d %s", hour, minute, second, am_pm));
            if (Timer) {
                if (tseconds == 0) {
                    Timer = false;
                    //timer.setText("Time Out");
                } else {
                    //timer.setText(tseconds.toString());
                    tseconds--;
                }
            }
        }
    }), new KeyFrame(Duration.seconds(1)));
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
}