private class MoveListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        out.println("timer action called");
        int snakeX = 0;
        int snakeY = 0;
        for (int row = 0; row < positions.length; row++) {
            for (int col = 0; col < positions[row].length; col++) {
                if (positions[row][col] == 's') {
                    snakeX = row;
                    snakeY = col;
                }
            }
        }
        if (currentDir.equals("left")) {
            positions[snakeX - 1][snakeY] = 's';
            positions[snakeX][snakeY] = '\u0000';
            repaint();
        } else if (currentDir.equals("right")) {
            positions[snakeX + 1][snakeY] = 's';
            positions[snakeX][snakeY] = '\u0000';
            repaint();
        } else if (currentDir.equals("up")) {
            positions[snakeX][snakeY - 1] = 's';
            positions[snakeX][snakeY] = '\u0000';
            repaint();
        } else if (currentDir.equals("down")) {
            positions[snakeX][snakeY + 1] = 's';
            positions[snakeX][snakeY] = '\u0000';
            repaint();
        }
    }
}