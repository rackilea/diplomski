public class SquarePanel extends JPanel{
    Color color = Color.BLACK;
    static boolean isRed = false;

    public SquarePanel(){
        if (isRed){
            color = Color.BLACK;
            isRed = false;
        } else {
            color = Color.RED;
            isRed = true;
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeigth());
    }
}