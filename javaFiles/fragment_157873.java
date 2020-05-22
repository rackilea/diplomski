final Container parent=this; //we are a the parent container creation code
MouseListener myCommonListener=new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
        parent.dispatchEvent(e);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        parent.dispatchEvent(e);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        parent.dispatchEvent(e);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        parent.dispatchEvent(e);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        parent.dispatchEvent(e);
    }
};

JLabel label=new JLabel("This is the first Label");
label.addMouseListener(myCommonListener);

JLabel label2=new JLabel("This is the second Label");
label2.addMouseListener(myCommonListener);
//... and so on