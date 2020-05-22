for (int r = 0; r < panels.length; ++r) {
    for (int c = 0; c < panels[r].length; ++c) {
        // Do this to fix the "must be final" error:
        final int row = r;
        final int col = c;
        panels[row][col].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panels[row][col].setBorder(.....);
            }
            // ..... more
        });
    }
}