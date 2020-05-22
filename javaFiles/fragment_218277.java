public void actionPerformed(ActionEvent e) {
    if (x < 150 && y < 150) {
        x++;
        y++;
    } else {
        ((Timer)e.getSource()).stop();
    }
    repaint();
}