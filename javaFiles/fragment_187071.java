...
List<JFrame> frames = new ArrayList<JFrame>();
JFrame frame1 = new JFrame();
JFrame frame2 = new JFrame();
JFrame frame3 = new JFrame();
Image icon1 = new ImageIcon("icon1.png").getImage();
Image icon2 = new ImageIcon("icon2.png").getImage();
Image icon3 = new ImageIcon("icon3.png").getImage();

frames.add(frame1);
frames.add(frame2);
frames.add(frame3);

setIcons(frames, icon1); //Set all frames to use icon 1

//DO OTHER STUFF

setIcons(frames, icon3); //Set all frames to use icon 3
...