public class Controller {

static double a=2, b=1, c=0;

public static void grid (Graphics g){
            g.setColor(Color.blue);
            g.drawLine(200,0,200,400);
            g.drawLine(0,200,400,200);
            for (int x=0; x<=400; x= x +40){
                g.drawLine(x,195,x,205);
            }
            for (int y=0; y<=400; y=y+40){
                g.drawLine(195,y,205,y);
            }
}

public static void Graphic1(Graphics g) {
            g.setColor(Color.red);
            for (double x=-100;x<=100;x = x+0.1){
                double y = a * x * x + b * x + c;
                int X = (int)Math.round(200 + x*20);
                int Y = (int)Math.round(200 - y*20);
                g.fillOval(X-2,Y-2,4,4);
            }   

}

}