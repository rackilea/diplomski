JFrame frame = new JFrame();
    B b = new B();
    b.setOpaque(false);


    frame.setUndecorated(true);
    frame.setBackground(new Color(0, 0, 0, 0));
    frame.setAlwaysOnTop(true);    
    // I'd prefer to override getPreferredSize of B
    frame.setPreferredSize(new Dimension(500, 500));
    frame.setLocationRelativeTo(null);        
    frame.add(b);
    frame.pack();
    frame.setVisible(true);