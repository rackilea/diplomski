BufferedImage img = new BufferedImage(recordingArea.width, recordingArea.height,
                    BufferedImage.TYPE_3BYTE_BGR);
            Graphics g = img.createGraphics();
            g.drawImage(screenShots.firstElement(), 0, 0, frame);
            JLabel l = new JLabel(new ImageIcon(img));
            frame.getContentPane().add(l);