class ClockListener implements ActionListener {
    int count = 0;
    public void actionPerformed(ActionEvent e) {
        int fakeSecond = (count++ % 10) + 1; 
        Calendar now = Calendar.getInstance();
        int h = now.get(Calendar.HOUR_OF_DAY);
        int m = now.get(Calendar.MINUTE);
        int s = now.get(Calendar.SECOND);
        _timeField.setText("" + h + ":" + m + ":" + fakeSecond);
    }
}