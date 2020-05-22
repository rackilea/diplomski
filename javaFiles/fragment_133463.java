public static void main(String[] args){
     final JFrame f = new JFrame();
     f.setSize(500, 400);
     f.setVisible(true);
     f.setLayout(null);
     f.setDefaultCloseOperation(3);

     final JButton b = new JButton("ToolTip");
     b.setBounds(100, 100, 70, 70);
     f.add(b);

     final JLabel toolTip = new JLabel();
     b.addMouseListener(new MouseListener() {

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
            f.remove(toolTip);
            f.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            try {
                toolTip.setIcon(new ImageIcon(ImageIO.read(new File("your image"))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            toolTip.setBounds(b.getLocation().x+b.getWidth(), b.getLocation().y-b.getHeight(), 100, 50);
            f.add(toolTip);
            f.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    });

}