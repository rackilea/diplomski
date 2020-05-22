JDateChooser chooser = new MyDateChooser();
this.add(chooser);
…
private static class MyDateChooser extends JDateChooser {

    @Override
    public void actionPerformed(ActionEvent e) {
        …
        Date date = dateEditor.getDate();
        if (date == null) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.YEAR, -10);
            calendar.setTime(c.getTime());
        } else {
            calendar.setTime(date);
        }
        jcalendar.setCalendar(calendar);
        …
    }
}