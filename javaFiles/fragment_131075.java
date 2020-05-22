public static Pixmap getPixmapCircle(int radius, Color color, boolean isFilled) {
        Pixmap pixmap=new Pixmap(2*radius+1, 2*radius+1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        if(isFilled)
            pixmap.fillCircle(radius, radius, radius);
        else
            pixmap.drawCircle(radius, radius, radius);
        pixmap.drawLine(radius, radius, 2*radius, radius);
        Pixmap.setFilter(Pixmap.Filter.NearestNeighbour);
        return pixmap;
}

Texture texture=new Texture(getPixmapCircle(10, Color.RED, true));

Image image=new Image(texture);
or
Sprite sprite=new Sprite(texture);