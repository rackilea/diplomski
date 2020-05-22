JPanel[] row = new JPanel[12];
    for (int i = 0; i < 12; i++) {
        row[i] = new JPanel();
        frame.add(row[i]);
        row[i].setBounds(0, i * 25, 300, 25);
        row[i].setVisible(true);

        JButton[] button = new JButton[12];
        for (int j = 0; i < 12; i++) {
            button[j] = new JButton();
            row[i].add(button[j]);
            button[j].setBounds(i * 25, 0, 25, 25);
            button[j].setVisible(true);

        }
    }