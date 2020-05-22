JTextComponent jtc = EditorRegistry.lastFocusedComponent();

jtc.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    JOptionPane.showMessageDialog(null, "1 Left: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_RIGHT:
                    JOptionPane.showMessageDialog(null, "1 Right: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_DOWN:
                    JOptionPane.showMessageDialog(null, "1 Down: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_UP:
                    JOptionPane.showMessageDialog(null, "1 Up: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_ENTER:
                    JOptionPane.showMessageDialog(null, "Enter: "+e.getKeyCode());
                    break;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    JOptionPane.showMessageDialog(null, "2 Left: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_RIGHT:
                    JOptionPane.showMessageDialog(null, "2 Right: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_DOWN:
                    JOptionPane.showMessageDialog(null, "2 Down: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_UP:
                    JOptionPane.showMessageDialog(null, "2 Up: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_ENTER:
                    JOptionPane.showMessageDialog(null, "Enter: "+e.getKeyCode());
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    JOptionPane.showMessageDialog(null, "3 Left: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_RIGHT:
                    JOptionPane.showMessageDialog(null, "3 Right: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_DOWN:
                    JOptionPane.showMessageDialog(null, "3 Down: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_UP:
                    JOptionPane.showMessageDialog(null, "3 Up: " + e.getKeyCode());
                    break;
                case KeyEvent.VK_ENTER:
                    JOptionPane.showMessageDialog(null, "Enter: "+e.getKeyCode());
                    break;
            }
        }
    });