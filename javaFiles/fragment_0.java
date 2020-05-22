for(int i = 0; i < 3; i++)
    for(int j = 0; j < 5; j++) {
        final JButton btn = btn1[i][j];
        btn1[i][j].addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btn.setBackground(Color.RED);
                }
            }
        );
    }