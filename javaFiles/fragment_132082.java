// Create the JFrame
JFrame jframe = new JFrame();
jframe.setSize(800, 400);
jframe.setResizable(false);
jframe.setLayout(null);
jframe.setVisible(true);

Surface mySurface = new Snake(true); //I do not know why you need boolean here, really

jframe.add(mySurface); // Add the JPanel to the JFrame