Button x, y; //initialized somewhere
ActionListener l = new ActionListener() {
    public void onActionPerformed(ActionEvent evt) {
        if(evt.getSource() == x) {
            //Do action for x
        } else if (evt.getSource() == y) {
            //Do action for y
        }
}
x.addActionListener(l);
y.addActionListener(l);