public static void main(String[] args) {

  EventQueue.invokeLater(new Runnable() {
    JFrame frame=new JFrame();
    JButton button = new JButton("click me");

    frame.getContentPane().add(button); 
    frame.setSize(300,300);
    frame.setVisible(true);
  });
}