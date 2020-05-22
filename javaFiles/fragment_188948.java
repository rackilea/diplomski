public static class MouseFrame extends FontFrame implements MouseListener {

    public MouseFrame() {
        super();
        myName.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("...");
        int fontbutton = e.getButton();
        if (fontbutton == MouseEvent.BUTTON1) {
            myName.setForeground(Color.red);
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
    }

}