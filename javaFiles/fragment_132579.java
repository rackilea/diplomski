public JTextArea maakVak(JPanel p) {
    JTextArea vak = new JTextArea(80, 120);    
    vak.setEditable(false);  
    vak.addMouseListener(textAreaMouseListener());
    p.add(vak);
    return vak; //return JTextarea to save in the ArrayList
}

private MouseListener textAreaMouseListener() {

    return new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTextArea vak = (JTextArea) e.getComponent();
            //display popup to make changes
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };
}