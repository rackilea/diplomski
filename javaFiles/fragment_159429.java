frame2 = new JFrameCloseEvent();
frame2.setSize(800, 800);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame2.setTitle("CityTours English Version");
JPanel Paneel2 = new Paneel();
frame2.setContentPane(Paneel2);
//set visibility to false because frame1 is visible at beginning
frame2.setVisible(false);