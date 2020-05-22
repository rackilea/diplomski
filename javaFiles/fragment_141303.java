public class JPanelListFrame {
    private JFrame frame;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JPanelListFrame window = new JPanelListFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public JPanelListFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 210, 192);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanelList panelList = new JPanelList();
        frame.getContentPane().add(panelList, BorderLayout.CENTER);
        JButton btnAddMypanel = new JButton("Add MyPanel");
        btnAddMypanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // just add a MyPanel with a Value containing a
                // "asdf" and a random boolean
                panelList.addPanel(new MyPanel(new Value("asdf",
                        (int) (2 * Math.random()) % 2 == 0)));
            }
        });
        panelList.add(btnAddMypanel, BorderLayout.SOUTH);
    }
}