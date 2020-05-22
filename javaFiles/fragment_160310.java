public class Rectangle {
    final public Point upperLeftCorner;
    final public Point upperRightCorner;
    final public Point lowerLeftCorner;
    final public Point lowerRightCorner;
    final public double height;
    final public double length;

    public Rectangle(double upper_left_x, double upper_left_y, double height, double length)
    {
        upperLeftCorner = new Point(upper_left_x, upper_left_y);
        upperRightCorner = new Point(upper_left_x + length, upper_left_y);
        lowerLeftCorner = new Point(upper_left_x, upper_left_y - height);
        lowerRightCorner = new Point(upper_left_x + length, upper_left_y - height);
        this.height = height;
        this.length = length;
    }

    //returns true if this and r overlap on the horizontal axis
    public boolean overlapsHorizontally(Rectangle r)
    {
       return  Math.abs(upperLeftCorner.x - r.upperLeftCorner.x) <= Math.max(length, r.length);
    }

    //returns true if this and r overlap on the vertical axis
    public boolean overlapsVertically(Rectangle r)
    {
        return  Math.abs(upperLeftCorner.y - r.lowerLeftCorner.y) <= Math.max(height, r.height);
    }

    public double minDistanceFrom(Rectangle r)
    {
        //If same rectangle
        if(this == r)
        {
            return 0;
        }

        //if they overlap in both directions then they actually overlap, so distance is 0
        if(overlapsHorizontally(r) && overlapsVertically(r))
        {
            return 0;
        }

        if(overlapsHorizontally(r))
        {
            //we know they don't overlap vertically so the result is simply the vertical distance between the 2 closest horizontal sides
            if(upperLeftCorner.y > r.upperLeftCorner.y)
            {
                return lowerLeftCorner.y - r.upperLeftCorner.y;
            }
            return r.lowerLeftCorner.y - upperLeftCorner.y;
        }
        else if(overlapsVertically(r))
        {
            //we know they don't overlap horizontally so the result is simply the horizontal distance between the 2 closest vertical sides
            if(upperLeftCorner.x < r.upperLeftCorner.x)
            {
                return r.upperLeftCorner.x - upperRightCorner.x;
            }
            return upperLeftCorner.x - r.upperRightCorner.x;
        }
        else //shitty case where they don't overlap in any direction
        {
            //this is above r
            if(upperLeftCorner.y > r.upperLeftCorner.y)
            {
                //this is above and to the left of r
                if(upperLeftCorner.x < r.upperLeftCorner.x)
                {
                    return lowerRightCorner.getDistanceFrom(r.upperLeftCorner);
                }
                else //this is above and to the right of r
                {
                    return lowerLeftCorner.getDistanceFrom(r.upperRightCorner);
                }
            }
            else //this is below r
            {
                //this is below and to the left of r
                if(upperLeftCorner.x < r.upperLeftCorner.x)
                {
                    return upperRightCorner.getDistanceFrom(r.lowerLeftCorner);
                }
                else //this is below and to the right of r
                {
                    return upperLeftCorner.getDistanceFrom(r.lowerRightCorner);
                }
            }
        }
    }
}