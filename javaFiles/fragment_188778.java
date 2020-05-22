public class WiLi_Horse {
    Ellipse body;
    Rectangle leg1;
    Rectangle leg2;
    Circle head;
    String name;

    public WiLi_Horse(Ellipse body, Rectangle leg1, Rectangle leg2, Circle head, String name) {
        this.body = body;
        this.leg1 = leg1;
        this.leg2 = leg2;
        this.head = head;
        this.name = name;
    }
    public List<Shape> getHorse()
    {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(body);
        shapes.add(leg1);
        shapes.add(leg2);
        shapes.add(head);
        return shapes;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "WiLi_Horse{" +
                "body=" + body +
                ", leg1=" + leg1 +
                ", leg2=" + leg2 +
                ", head=" + head +
                ", name='" + name + '\'' +
                '}';
    }
}