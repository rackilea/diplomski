class Class2 extends JPanel{
    private int xPos, yPos;
    public static void createJFrame(Class2 obj){
            JFrame window = new JFrame();
            window.setVisible(true);
            window.setSize(300, 300);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container c = window.getContentPane();
            c.add(obj);
    }
    public void setVal(int x, int y){
            xPos = x;
            yPos = y;
            repaint();
    }
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString("This string should be at 100, 200", xPos, yPos);
    }
 }

public class Test {
   public static void main(String[] args){
         Class2 obj = new Class2();
         obj.setVal(100, 200);
         Class2.createJFrame(obj);
   }
}