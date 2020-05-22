private void mouseClicked(java.awt.event.MouseEvent evt) {

    JPanel panel = (JPanel)evt.getSource();
    Color c = panel.getBackground();
    System.out.println("color: " + c.toString());

}