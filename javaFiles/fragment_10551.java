for (int y = 0; y < y_length; y++) {
    for (int x = 0; x < x_length; x++) {               
        buttons[x][y] = new JButton("X");
        buttons[x][y].addMouseListener(new ButtonMouseListener(x, y));
        mines_array.add(buttons[x][y]);
    }
}