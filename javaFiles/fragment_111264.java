public class Board extends JComponent{
    public void paint(Graphics b){
        b.setColor(Color.BLUE); // Just to make the color more obvious
        b.fillRect(0, 0, Game.mWidth, Game.mHeight);
        repaint();
    }
}