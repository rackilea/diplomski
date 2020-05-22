public class Employee1 extends JFrame {
    private final JPanel panel;
    private final JLabel l1;
    private final JList<String> list;    // <--- first change

    public Employee1() {
        super("Employee Details");

        final String[] cities = {"Mumbai", "Delhi", "Madras"};

        panel = new JPanel();
        l1    = new JLabel("City : ");
        list  = new JList<>(cities);     // <--- second change

        panel.add(l1);
        panel.add(list);
        getContentPane().add(panel);

        setSize(400, 400);
        setVisible(true);
    }    
}