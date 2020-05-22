public static void main(String[] args){
    Sea_InvadersDisplay display = new Sea_InvadersDisplay();
    JFrame frame = new JFrame();
    frame.add(display);
    frame.pack();
    frame.setTitle("Sea Invaders");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.getContentPane().setBackground( Color.BLUE );
    frame.setVisible(true);
    display.start();
}