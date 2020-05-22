// Read from same package 
ImageIO.read(getClass().getResourceAsStream("folder63.png"));

// Read from images folder parallel to src in your project
ImageIO.read(new File("images/folder63.jpg"));

// Read from src/images folder
ImageIO.read(getClass().getResource("/images/folder63.png"))

// Read from src/images folder
ImageIO.read(getClass().getResourceAsStream("/images/folder63.png"))