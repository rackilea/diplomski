public static List<Integer> subList(List<Integer> l) {
    List<Integer> evenL = new ArrayList<Integer>();

    for (int i = 0; i < l.size(); i++)
    {
         if (l.get(i) % 2 ==0)
         {
             evenL.add(i);
         }
    }
    return evenL;
}