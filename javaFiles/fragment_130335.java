class PointAdapter extends XmlAdapter<String, Point> {

    @Override
    public String marshal(Point v) throws Exception {
        return String.format("%d;%d", v.x, v.y);
    }

    @Override
    public Point unmarshal(String v) throws Exception {
        String[] coords = v.split(";");
        return new Point(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }

}