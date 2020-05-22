@Override
        public void keyPressed(KeyEvent e) {
            System.out.println("test");
            if(e.getKeyCode() == KeyEvent.VK_UP) {
                input.setText(inputValue);
                System.out.println("up is pressed");

        }