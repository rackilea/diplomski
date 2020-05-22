Timer timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += direction;
                    FontMetrics fm = getFontMetrics(getFont());
                    System.out.println(xPos + "; " + scale);
                    if (scale > 0 && xPos > getWidth()) { // this condition fires when the text banner reaches the right banner
                        xPos = -(getWidth() + fm.stringWidth(msg));
                        scale = -1;
                    } else if (scale < 0 && xPos >= 0) {
                        xPos = -fm.stringWidth(msg);
                        scale = 1;
                    }
                    repaint();
                }
            });