label.addMouseListener(new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent arg0) {
            label.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        @Override
        public void mouseReleased(MouseEvent arg0) {
            label.setBorder(null);
        }
    });