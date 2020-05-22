Font font = null;

    try {
       font = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("/DroidSans-Bold.ttf").getFile()));
       font = font.deriveFont(32f); // Set size to 32
    } catch (FontFormatException | IOException e) {
       e.printStackTrace();
    }

    JFrame jf = new JFrame();
    jf.setSize(800, 600);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);

    Graphics2D g = (Graphics2D)jf.getGraphics();

    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g.setFont(font);
    g.drawString("Hello", 100, 100);