public class Scrol extends JFrame {

    Scrol() {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(0, 1));
        p1.setBorder(BorderFactory.createLineBorder(new Color(200, 167, 0)));
        getContentPane().add(new JScrollPane(p1), BorderLayout.CENTER);

        for (int n = 1; n < 100; n++)
            p1.add(new JPanel().add(new JLabel("hello")));

        setSize(500, 500); // or pack()
        setVisible(true);
    }

    public static void main(String[] args) {

        new Scrol();
    }
}