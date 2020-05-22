public class TestPanel1 {
    JPanel panel1;
    JButton next;

    public TestPanel1(final JFrame frame, TestPanel2 tp2) { // was: JPanel panel1() {
        panel1 = new JPanel();
        next = new JButton("Next");
        final JPanel panel2 = tp2.panel2; // line created
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                panel2.removeAll(); // was: new TestPanel2().panel2.removeAll();
                frame.validate(); // line created
                frame.paint(); // line created
            }
        });
        panel1.add(next);
                         // was: return panel1;
    }
}