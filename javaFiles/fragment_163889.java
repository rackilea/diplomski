public class RectangleXmlAdapter extends XmlAdapter<MyRectangle, Rectangle> {

    @Override
    public Rectangle unmarshal(MyRectangle v) throws Exception {
        if (v == null)
            return null;
        return new Rectangle(v.getX(), v.getY(), v.getWidth(), v.getHeight());
    }

    @Override
    public MyRectangle marshal(Rectangle v) throws Exception {
        if (v == null)
            return null;
        return new MyRectangle(v.x, v.y, v.width, v.height);
    }
}