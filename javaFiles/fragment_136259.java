class Question {

int count = 0;
ArrayList<JTextField>[] jt;
JPanel buttonPanel;;
JScrollPane scrollPane;

public Question() {
    final JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    f.setResizable(false);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JMenuBar mnuBar = new JMenuBar();

    JMenu mnu1 = new JMenu("ثبت");
    mnu1.setMnemonic(KeyEvent.VK_E);

    buttonPanel = new JPanel();
    buttonPanel.setBorder(BorderFactory.createLineBorder(Color.red));
    buttonPanel.setLayout(new BoxLayout(buttonPanel, 1));

    scrollPane  = new JScrollPane(buttonPanel);
    f.getContentPane().add(scrollPane);

    JMenuItem menuItem = new JMenuItem("Insert Places", KeyEvent.VK_T);
    menuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            count = 0;
            jt = new ArrayList[4];
            for (int i = 0; i < 4; i++)
                jt[i] = new ArrayList<JTextField>();


           for (int i = 0; i < 100; i++) {
                buttonPanel.add(new JButton("kjdh"));
           }

           buttonPanel.revalidate(); // calling revalidate 
           buttonPanel.repaint();// calling repaint

        }
    });

    mnu1.add(menuItem);
    mnuBar.add(mnu1);
    f.setJMenuBar(mnuBar);
    f.pack();
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setVisible(true);
}

public static void main(String[] args) {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            new Question();
        }
    };
    SwingUtilities.invokeLater(r);
} 
}