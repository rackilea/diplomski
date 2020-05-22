@Override
     public void keyPressed(KeyEvent e) {
        int oldRedPoint = redPoint;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
           j--;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
           j++;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
           i--;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           i++;
        }
        redPoint = (i * 8) + j;
        labels[oldRedPoint].setIcon(bg);
        labels[redPoint].setIcon(red);
     }