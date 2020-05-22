for (int i = 0; i < COLORS.length; i++) {

            BufferedImage img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
            BufferedImage buffer = img;
            Graphics2D g = img.createGraphics();
            g.setColor(Color.WHITE);
            g.fillOval(8, 8, 14, 14);

            for (int y = 0; y < buffer.getHeight(); y++) {
                for (int x = 0; x < buffer.getWidth(); x++) {
                    if ((buffer.getRGB(x, y) & 0xFF000000) == 0xFF000000) {
                        buffer.setRGB(x, y, COLORS[i].getRGB());
                    }
                }
            }
            panel.add(new JButton(new ImageIcon(buffer)));
        }