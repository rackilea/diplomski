// Check for a draw
boolean draw = true;
for (int i  = 0; i < 6; i ++) {
    for (int j = 0; j < 7; j ++) {
        if (imageName[i][j].getIcon() == null) {
            draw = false;
        }

if (draw) {
    JOptionPane.showMessageDialog(null, "It's a draw!");
    clearGrid();
}