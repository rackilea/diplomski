public class TESTMAIN extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TESTMAIN frame = new TESTMAIN();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TESTMAIN() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        panel.add(greenPanel, BorderLayout.CENTER);

        final JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        panel.add(bluePanel, BorderLayout.SOUTH);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JButton button1 = new JButton("New button");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bluePanel.setVisible(false);
            }
        });
        panel_1.add(button1, BorderLayout.WEST);

        JButton button2 = new JButton("New button");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bluePanel.setVisible(true);
            }
        });
        panel_1.add(button2, BorderLayout.EAST);
    }

}