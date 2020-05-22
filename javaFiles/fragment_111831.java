JLabel label      = new JLabel(); 
label.setLocation(0,0);
label.setIcon(new ImageIcon(world.getSprite()));
label.setVisible(true);   

JFrame frame      = new JFrame();
frame.setVisible(true);
frame.setSize(783,615);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(label);

Sprite archer = new Sprite(ImageIO.read(new File("C:/Users/sfiel42/Documents/game/archer.png")));
archer.spawn(frame,world.getSprite(),250,400);
archer.erase(frame,world.getSprite(),orig_world.getSprite());