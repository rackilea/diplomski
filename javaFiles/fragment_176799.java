import java.awt.Point;

public class Main {
    public Main()  {
      Point point = new Point(1, 1);
      Double doub = point.getX(); // Returns double, You dont have to cast

    }

    public static void main(String[] args){
        Main main = new Main();
    }
}