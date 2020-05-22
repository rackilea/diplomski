for (int a = 0; a<buttons.length; a++) {
    for (int b = 0; b < buttons[0].length; b++) {
        buttons[a][b] = new JButton("▒");
        buttons[a][b].addActionListener(this);
        final int finalB = b;
        final int finalA = a;
        buttons[a][b].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    mineFlagger(true, finalA, finalB);
                }
            }
        });
        grid.add(buttons[a][b]);
    }
}


public void mineFlagger (boolean flag, int x, int y){
    buttons[x][y].setText("F");
}