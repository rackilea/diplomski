this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right1down");
this.getActionMap().put("right1down", new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        p1Right = true;
    }
});

this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right1up");
this.getActionMap().put("right1up", new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        p1Right = false;
    }
});