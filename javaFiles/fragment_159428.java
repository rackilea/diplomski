//already declared frame1 outside main method
frame1 = new JFrameCloseEvent();
frame1.setSize(800, 800);
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.setTitle("CityTours Default Language");
JPanel Paneel = new Paneel();
frame1.setContentPane(Paneel);
//frame1 be visible when program start
frame1.setVisible(true);