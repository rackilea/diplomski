public frame() {
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    int i = 4;
    int j = 4;
    JPanel[][] panelHolder = new JPanel[i][j];

    for (int a = 0; a < i; a++) {
        for (int b = 0; b < j; b++) {
            panelHolder[a][b] = new JPanel();
            add(panelHolder[a][b]);
        }
    }
    panelHolder[3][2].setForeground(Color.BLUE);
    JButton enter = new JButton("Enter");
    panelHolder[0][0].add(enter);

    setVisible(true);
}