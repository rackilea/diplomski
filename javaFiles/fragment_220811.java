final JLabel label = new JLabel("some label with a nice text");
    label.setBackground(Color.YELLOW);
    MouseAdapter adapter = new MouseAdapter() {

        /** 
         * @inherited <p>
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setOpaque(true);
            label.repaint();
        }

        /** 
         * @inherited <p>
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setOpaque(false);
            label.repaint();
        }

    };
    label.addMouseListener(adapter);