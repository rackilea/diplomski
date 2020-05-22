public class Test {

    public static void main(String[] args) {
        final JDialog jd1 = new JDialog((JFrame) null, "Dialog 1", false);
        jd1.setVisible(true);

        JDialog jd2 = new JDialog((JFrame) null, "Dialog 2", false);
        jd2.setVisible(true);
        jd2.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                jd1.dispose();
            }
        });
    }
}