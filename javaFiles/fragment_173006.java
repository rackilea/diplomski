import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class RectGroup extends ArrayList<Rectangle> implements List<Rectangle>
{
    public RectGroup(Rectangle... rects)
    {
            super(rects);
    }

    public RectGroup()
    {
        super();
    }

    public boolean intersects(Rectangle rect)
    {
        for(Rectangle r : this)
            if(rect.intersects(r))
                return true;

        return false;
    }

    public List<RectGroup> getDistinctGroups()
    {
        List<RectGroup> groups = new ArrayList<RectGroup>();
        // Create a list of groups to hold grouped rectangles.

        for(Rectangle newRect : this)
        {
            List<RectGroup> newGroupings = new ArrayList<RectGroup>();
            // Create a list of groups that the current rectangle intersects.

            for(RectGroup group : groups)
                if(group.intersects(newRect))
                    newGroupings.add(group);
            // Find all intersecting groups

            RectGroup newGroup = new RectGroup(newRect);
            // Create a new group

            for(List<Rectangle> oldGroup : newGroupings)
            {
                groups.remove(oldGroup);
                newGroup.addAll(oldGroup);
            }
            // And merge all the intersecting groups into it

            groups.add(newGroup);
            // Add it to the original list of groups
        }
        return groups;
    }
}