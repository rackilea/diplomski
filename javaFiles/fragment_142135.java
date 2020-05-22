int delay = 1000;
  final Timer timer = new Timer(delay, new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
        // TODO put in code to repeat
        // including swapping a JLabel's image icon
     }
  });
  JButton btn = new JButton("Foo");
  btn.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent arg0) {
        timer.start(); // or stop if you want to stop the swapping
     }
  });