public class panel extends JPanel{
public int X = 50; //Starting x
public int Y = 50; //Starting y
public panel(){

}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    g.drawString("Hello this will be moved", X, Y);//<--- This draws the text
}