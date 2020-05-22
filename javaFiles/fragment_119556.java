class ImageMap<T> 
{
    private final Map<Rectangle2D, T> map;

    ImageMap()
    {
        map = new LinkedHashMap<Rectangle2D, T>();
    }

    public T get(double x, double y)
    {
        for (Entry<Rectangle2D, T> entry : map.entrySet())
        {
            Rectangle2D key = entry.getKey();
            if (key.contains(new Point2D.Double(x,y)))
            {
                return entry.getValue();
            }
        }
        return null;
    }

    void setBounds(T t, Rectangle2D r)
    {
        Rectangle2D copy = new Rectangle2D.Double(
            r.getX(), r.getY(), r.getWidth(), r.getHeight());
        map.put(copy, t);
    }
}