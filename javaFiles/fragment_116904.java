class RadioButtonListener implements ActionListener
{
    private CalendarPanel cal;

    public RadioButtonListener(CalendarPanel cal) {
       this.cal = cal;
    }
    public void actionPerformed(ActionEvent e)
    {
        cal.formatCalendar(getDaysInMonth(), getFirstDayOfWeek());
        cal.revalidate();
        cal.repaint();
    }    
}