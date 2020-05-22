URL url = new URL("http://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Morus_bassanus_adu.jpg/50px-Morus_bassanus_adu.jpg");

                BufferedImage image = ImageIO.read(url);        

                JLabel label = new JLabel(new ImageIcon(image));
                label.setMinimumSize(new Dimension(200,200));
                this.add(label);