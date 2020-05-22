...
public void JButton1ActionPerformed(ActionEvent evt) {
    west.removeAll(); //If the old MyDrawing is the only thing 
                      //that has been added to west. Otherwise use
                      //remove(int index) or remove(Component comp)
    west.add(draw);
    west.revalidate();
    west.repaint();
}
...