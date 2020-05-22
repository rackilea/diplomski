jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jButton1.setBackground(Color.GREEN);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jButton1.setBackground(UIManager.getColor("control"));
    }
});