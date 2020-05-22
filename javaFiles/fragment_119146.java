square[i][j] = new JButton() {
           @Override  // !! add this:
           protected void paintComponent(Graphics g) {
              if (!isOpaque() && getBackground().getAlpha() < 255) {
                 g.setColor(getBackground());
                 g.fillRect(0, 0, getWidth(), getHeight());
             }
             super.paintComponent(g);
           }
        };
        square[i][j].setRolloverEnabled(false);
        square[i][j].setOpaque(false); // !! and also add this *******