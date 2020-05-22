private static boolean hasSubListsOfSize (LinkedList<Object> superList, final int groupSize)
{
     for (int i = 0, size = superList.size(); i < size; i++)
     {
         LinkedList<Object> subList = (LinkedList<Object>) superList.get(i);
         if (subList.size() == groupSize)
         {
            return true;
         }
     }

     // didn't find any sub lists of the group size
     return false;
}