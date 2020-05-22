public class TestPanel2 {
    JPanel panel2;
    JList jlist;
    String[] list = { "Sachin", "Tarun", "Vipin" };

    public TestPanel2() { // was: JPanel panel2() {
        panel2 = new JPanel();
        jlist = new JList(list);
        panel2.add(jlist);
        panel2.add(new JLabel("Test"));
                      // was: return panel2;
    }
}