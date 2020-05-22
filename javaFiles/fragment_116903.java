class RadioButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        // the line below creates a *new* CalendarPanel object
        // one completely unrelated to the displayed CalendarPanel 
        CalendarPanel cal = new CalendarPanel();
        cal.formatCalendar(getDaysInMonth(), getFirstDayOfWeek());
        cal.revalidate();
        cal.repaint();
    }    
}