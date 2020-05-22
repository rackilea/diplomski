@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewcart) {
        Cart2 c = new Cart2(this);
        c.setVisible(true);
        c.setSize(250, 230);
    }
}