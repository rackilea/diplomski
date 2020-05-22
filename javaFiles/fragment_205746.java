public static void createGUI(){
    JFrame frame = new JFrame("My Frame");
    JComponent component = new Drawing();
    component.setOpaque(true);
    frame.add(component);
    frame.setSize(600,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}