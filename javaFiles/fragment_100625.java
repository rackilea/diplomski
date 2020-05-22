public class CalendarTest2 extends JFrame {
    private static final long serialVersionUID = 1L;

    public CalendarTest2() {
        Calendar cal = Calendar.getInstance();
        JCalendar jCalendar1 = new JCalendar();
        cal.setTime(jCalendar1.getDate());
        int dayToBeSelected = cal.get(Calendar.DAY_OF_MONTH);
        dayToBeSelected = 21;

        JPanel jpanel = jCalendar1.getDayChooser().getDayPanel();
        Component compo[] = jpanel.getComponents();
        for (Component comp : compo) {
            if (!(comp instanceof JButton))
                continue;

            JButton btn = (JButton) comp;
            if (btn.getText().equals(String.valueOf(dayToBeSelected)))
                comp.setBackground(Color.red);
        }
        add(jpanel);
    }

    public static void main(String[] args) {
        CalendarTest2 test = new CalendarTest2();
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(800, 800);
    }
}