public class mypanel extends JPanel implements ActionListener {
    JButton b;
    Color c1, c2, currentColor;
    boolean isRed = true;
    int x, z, q;
    public mypanel() {
        this.setVisible(true);
        this.setBackground(Color.darkGray);
        b = new JButton("change color");
        add(b);
        b.setBounds(110, 0, 30, 50);
        b.addActionListener(this);
        c1 = Color.green;
        currentColor = c2 = Color.red;
        x = 80;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocus();
        g.setColor(Color.black);
        g.fillRect(110, 70, 60, 100);
        g.setColor(currentColor);
        g.fillOval(125, x, 30, 30);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            if (isRed){
                currentColor = c1;
                x = 130;
                isRed = false;
            } else {
                currentColor = c2;
                x = 80;
                isRed = true;
            }
        }
        repaint();
    }
}