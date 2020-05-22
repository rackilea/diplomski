public class Main extends JPanel {  
    @Override
    public void paint(Graphics g){    
        Font font = new Font("Serif",Font.HANGING_BASELINE,45);
        g.setFont(font); // first set font
        g.setColor(Color.red); // and color
        g.drawString("My name is salman", 99, 99); // and after that draw a sting
    }

    public static void main(String[] args){
       JFrame f = new JFrame();
       f.getContentPane().add(new Main());
       f.setVisible(true);
       f.setSize(700, 600);
    }
}