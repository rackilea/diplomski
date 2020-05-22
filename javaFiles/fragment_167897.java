setTitle("Chess game");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    ImageIcon img = new ImageIcon("pieceImages/whiteKing.png");
    contentPane = getContentPane();

    contentPane.setLayout(new BorderLayout());

    Toolbar toolbar = new Toolbar();

    JPanel labelsPanel = new JPanel();

    GridLayout gridLayout = new GridLayout(8, 8);
    labelsPanel.setLayout(gridLayout);
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            labels[i][j]=new JLabel(game.getBoard()[i][j].getImagePath());
            labelsPanel.add(labels[i][j]);
        }
    }

    contentPane.add(toolbar, BorderLayout.NORTH);
    contentPane.add(labelsPanel, BorderLayout.CENTER);

    setIconImage(img.getImage());
    setResizable(false);
    setSize(600, 600);
    setLocationRelativeTo(null);
    setVisible(true);