public class test {
public static void main(String ap[])
{

    List<Point> mList1 =new ArrayList<Point>();
    List<Point> mList2 =new ArrayList<Point>();
    Point mPoint1 = new Point(1, 2);
    Point mPoint2 = new Point(2, 3);

    for (int i=0;i<3;i++){
        mList1.add(mPoint1);
        mList1.add(mPoint2);
    }
    Point mPoint3 = new Point(1, 2);
    Point mPoint4 = new Point(3, 4);

    for (int i=0;i<2;i++){
        mList2.add(mPoint3);
        mList2.add(mPoint4);
    }

    System.out.println(mList1);
    //System.out.println(mList2);
    new test().removingDuplicatesQID(mList1, mList2);
    System.out.println(mList1);
}
public void removingDuplicatesQID(List<Point> list1,List <Point> list2)
{
    Set<Point> uniqueEntries = new HashSet<Point>();
    for (Iterator iter = list1.iterator(); iter.hasNext();)
    {
        Point element = (Point) iter.next();
        if (!uniqueEntries.add(element))
            /* if current element is a duplicate, remove it */
            iter.remove();
    }
    uniqueEntries.clear();
}
}