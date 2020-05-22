JFrame frame = new JFrame("Minesweeper");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int width = 800;
    frame.setSize(width, width);
    frame.setResizable(false);
    frame.setLocation(0,0);
    frame.setVisible(true);

    int w = 80;

    JButton[][] button = new JButton[10][10];
    for (int i = 0; i < 10 ; i++ ) {

        for (int j = 0; j < 10 ; j++ ) {
            button[i][j]  = new JButton();
            button[i][j].setBounds(i*80 , j*80 , w , w);
            frame.add(button[i][j]);

        }
    }