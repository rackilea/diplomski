public static List<Integer> max2List (List<Integer> list1, List<Integer> list2)
{
    List<Integer> maxValues = new LinkedList<>();

    for (int i = 0; i < list1.size(); ++i)
    {
        // If item in list1 is larger, add it
        if (list1.get(i).compareTo(list2.get(i)) > 0)
        {
            maxValues.add(list1.get(i));
        }
        else // else add the item from list2
        {
            maxValues.add(list2.get(i));
        }
    }

    return maxValues;
}