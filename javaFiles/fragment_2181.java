public class example extends JFrame{

    public example() {
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.red);

        Area shape1 = new Area(new RoundRectangle2D.Double(0, 0, 200, 252, 30, 30));
        Area shape2 = new Area(new Rectangle(0, 252-30, 200, 100));
        shape1.add(shape2);
        this.setShape(shape1);
        this.setSize(300, 400);
    }
    public static void main(String[] args) {
        new example().setVisible(true);
    }

}