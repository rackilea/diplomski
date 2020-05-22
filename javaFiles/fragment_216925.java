label[r][c].setIcon(p1Chip); // set the icon of the label
label[r][c] = new JLabel(); // replace the label in the array, containing the icon, by a new one, without any icon
board[r][c] = new JPanel(); // replace the already initialized panel in the board by a new, empty one

...

board[r][c].add(label[r][c]); // add the empty label to the empty panel.