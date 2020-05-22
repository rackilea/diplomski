public class NuovaPartitaViewer extends JFrame {

    public NuovaPartitaViewer() {
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Panel 1"));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Panel 2"));
        JPanel p3 = new JPanel();
        p3.add(new JLabel("Panel 3"));
        JPanel p4 = new JPanel();
        p4.add(new JLabel("Panel 4"));

        JButton b1 = new JButton("Button 1");
        b1.addActionListener(e -> setPanel(p1));
        JButton b2 = new JButton("Button 2");
        b2.addActionListener(e -> setPanel(p2));
        JButton b3 = new JButton("Button 3");
        b3.addActionListener(e -> setPanel(p3));
        JButton b4 = new JButton("Button 4");
        b4.addActionListener(e -> setPanel(p4));

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);

        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.BLACK);
        add(buttonsPanel, BorderLayout.WEST);
        add(p1, BorderLayout.CENTER);

        setTitle("CHI VUOL ESSER MILIONARIO?");
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setPanel(JPanel p) {
        add(p, BorderLayout.CENTER);
        revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NuovaPartitaViewer());
    }
}