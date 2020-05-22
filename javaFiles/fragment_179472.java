public class Test1 extends JPanel{

public static void main(String[] args) {

    Test1 test = new Test1() ;

    JFrame frame = new JFrame() ;
    frame.add(test) ;
    frame.setSize(800 , 600) ;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    frame.setVisible(true) ;

}


@Override
public void paint(Graphics g) {     
    String text = "This is a text , Hello World!" ;

    g.drawString(text, 0, 100) ;        
    drawString(text, g, 0, 120) ;       
}

private void drawString (String s , Graphics g , int x , int y){
    for (int c1=0 ; c1 < s.length() ; c1++){

        char ch = s.charAt(c1); 
        g.drawString(ch+"", x, y) ;
        x+= g.getFontMetrics().charWidth(ch) ;
    }
}