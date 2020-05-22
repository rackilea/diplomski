ImageIcon yourImage = new ImageIcon("C:/path/to/your/file/cough.jpg");

    JLabel yourLabel = new JLabel();
    yourLabel.setLocation(x,y);
    yourLabel.setSize(width, heigh);
    yourLabel.setIcon(yourImage);

    yourFrame.add(yourLabel);