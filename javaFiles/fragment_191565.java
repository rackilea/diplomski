JFrame frame = new JFrame("Basic Swing");//Make a frame
    frame.setSize(300, 300);//Give it a size
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Make it go away on close
    JPanel panel = new JPanel();//Make a panel
    frame.add(panel);//Add it to your frame

    JLabel label = new JLabel("Hello StackOverflow!");//Make a label
    panel.add(label);//Add it to the panel (which is on the frame)

    frame.setVisible(true);//Show the frame