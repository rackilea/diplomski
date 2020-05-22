Sprite archer = new Sprite(ImageIO.read(new File("C:/Users/sfiel42/Documents/game/archer.png")));
archer.spawn(frame, world.getSprite());
frame.repaint();
Thread.sleep(2000);
System.out.println("Erasing");
archer.erase(frame, world.getSprite(), orig_world.getSprite());
frame.repaint();