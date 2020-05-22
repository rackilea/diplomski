public class Project .... {

    Color color = Color.RED;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ...
        g.setColor(color);
        ...
    }

    public void mouseClicked(MouseEvent e){
        color = Color.BLUE;
        repaint();
    }
}