im.put(KeyStroke.getKeyStroke("LEFT"), "shiftLeft");
    getActionMap().put("shiftLeft", new AbstractAction(){
        public void actionPerformed(ActionEvent e) {
            cube.shiftLeft();
            repaint();
        }
    });