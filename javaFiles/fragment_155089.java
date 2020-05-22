JFrame frame = new JFrame();
JPanel panel = new JPanel();
frame.add(panel);
panel.addMouseListener(new MouseAdapter() {
@Override 
public void mousePressed(MouseEvent e) {
    System.out.println(e.getX() + "," + e.getY());// clicked points in jframe

}
});
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 500);
frame.setVisible(true);