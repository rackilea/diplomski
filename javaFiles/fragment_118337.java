public boolean canWalk(String dir)
{
    int i = 0;
    while (true)
    {
        try
        {
            RectangleMapObject temp = (RectangleMapObject) ents.get(i);
            if (!temp.equals(player))
            {
                if (dir.equals("s"))
                {
                    float cy = ((y) * 16) - 2;
                    float cx = ((x) * 16) + 2;
                    if (temp.getRectangle().contains(cx + 6, cy + 8))
                    {
                        return false;
                    }
                }
                else if (dir.equals("n"))
                {
                    float cy = ((y + 1) * 16) + 2;
                    float cx = ((x) * 16) + 2;
                    if (temp.getRectangle().contains(cx, cy) && temp.getRectangle().contains(cx + 6, cy) && temp.getRectangle().contains(cx + 12, cy))
                    {
                        return false;
                    }
                }
                else if (dir.equals("e"))
                {
                    float cy = ((y) * 16) + 2;
                    float cx = ((x + 1) * 16) + 2;
                    if (temp.getRectangle().contains(cx, cy) && temp.getRectangle().contains(cx, cy + 6) && temp.getRectangle().contains(cx, cy + 12))
                    {
                        return false;
                    }
                }
                else if (dir.equals("w"))
                {
                    float cy = ((y) * 16) + 2;
                    float cx = ((x) * 16) - 2;
                    if (temp.getRectangle().contains(cx, cy) && temp.getRectangle().contains(cx, cy + 6) && temp.getRectangle().contains(cx, cy + 12))
                    {
                        return false;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            break;
        }
        i++;
    }
    i = 0;
    while (true)
    {
        try
        {
            PolygonMapObject temp = (PolygonMapObject) cols.get(i);
            if (dir.equals("s"))
            {
                float cy = ((y) * 16) - 2;
                float cx = ((x) * 16) + 2;
                if (temp.getPolygon().contains(cx, cy) && temp.getPolygon().contains(cx + 6, cy) && temp.getPolygon().contains(cx + 12, cy))
                {
                    return false;
                }
            }
            else if (dir.equals("n"))
            {
                float cy = ((y + 1) * 16) + 2;
                float cx = ((x) * 16) + 2;
                if (temp.getPolygon().contains(cx, cy) && temp.getPolygon().contains(cx + 6, cy) && temp.getPolygon().contains(cx + 12, cy))
                {
                    return false;
                }
            }
            else if (dir.equals("e"))
            {
                float cy = ((y) * 16) + 2;
                float cx = ((x + 1) * 16) + 2;
                if (temp.getPolygon().contains(cx, cy) && temp.getPolygon().contains(cx, cy + 6) && temp.getPolygon().contains(cx, cy + 12))
                {
                    return false;
                }
            }
            else if (dir.equals("w"))
            {
                float cy = ((y) * 16) + 2;
                float cx = ((x) * 16) - 2;
                if (temp.getPolygon().contains(cx, cy) && temp.getPolygon().contains(cx, cy + 6) && temp.getPolygon().contains(cx, cy + 12))
                {
                    return false;
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            break;
        }
        i++;
    }
    return true;
}