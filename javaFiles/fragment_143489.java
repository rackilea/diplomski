public void mousePressed(MouseEvent e)
{
    for (Shape shape : shapes)
    {
        if (shape.contains(e.getPoint())
            // do something
    }

}