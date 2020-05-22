public class ValueUpdate extends JFrame {

    int x = 0;
    final JLabel label = new JLabel(String.valueOf(x));

    ValueUpdate() {

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.add(label);

        JButton btn = new JButton("Increment");
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                x++;
                label.setText(String.valueOf(x));
            }
        });

        panel2.add(btn);

        getContentPane().add(panel1, BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.PAGE_END);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new ValueUpdate();
    }
}