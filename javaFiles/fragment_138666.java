public class Model {

    private List<Turtle> turtList = new ArrayList<>();
    private int turtleNumber = 3;

    Model() throws IOException {

        for (int i = 0; i < turtleNumber; i++) {
            Turtle turt = new Turtle();
            turt.setX(Math.round((float)Math.random() * 1000));
            turt.setY(Math.round((float)Math.random() * 700));
            turtList.add(turt);
        }
    }

    public void update(Graphics g) {

        for (int i = 0; i < turtleNumber; i++)
            turtList.get(i).update(g);
    }

    public void setDestination(int x, int y, int width, int height) {

        for (Turtle turt : turtList)
            turt.setDest(x, y);
    }
}