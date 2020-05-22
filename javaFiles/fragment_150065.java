@Override
public void modifyPath(PathConstructionRenderInfo renderInfo)
{
    List<Vector> points = new ArrayList<Vector>();
    if (renderInfo.getOperation() == PathConstructionRenderInfo.RECT)
    {
        float x = renderInfo.getSegmentData().get(0);
        float y = renderInfo.getSegmentData().get(1);
        float w = renderInfo.getSegmentData().get(2);
        float h = renderInfo.getSegmentData().get(3);
        points.add(new Vector(x, y, 1));
        points.add(new Vector(x+w, y, 1));
        points.add(new Vector(x, y+h, 1));
        points.add(new Vector(x+w, y+h, 1));
    }
    else if (renderInfo.getSegmentData() != null)
    {
        for (int i = 0; i < renderInfo.getSegmentData().size()-1; i+=2)
        {
            points.add(new Vector(renderInfo.getSegmentData().get(i), renderInfo.getSegmentData().get(i+1), 1));
        }
    }

    for (Vector point: points)
    {
        point = point.cross(renderInfo.getCtm());
        Rectangle2D.Float pointRectangle = new Rectangle2D.Float(point.get(Vector.I1), point.get(Vector.I2), 0, 0);
        if (currentPathRectangle == null)
            currentPathRectangle = pointRectangle;
        else
            currentPathRectangle.add(pointRectangle);
    }
}

@Override
public Path renderPath(PathPaintingRenderInfo renderInfo)
{
    if (renderInfo.getOperation() != PathPaintingRenderInfo.NO_OP)
    {
        if (textRectangle == null)
            textRectangle = currentPathRectangle;
        else
            textRectangle.add(currentPathRectangle);
    }
    currentPathRectangle = null;

    return null;
}

@Override
public void clipPath(int rule)
{
}