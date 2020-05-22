final Frame[] frames = Frame.getFrames();
for (Frame f : frames){ 
    f.dispose();
    Test2 newtet = new Test2();
    newtet.setVisible(true);
}