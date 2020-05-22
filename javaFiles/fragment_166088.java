public static void sortAndRemoveDups(List<Integer>listToFix)
{
    Set<Integer> listToFix1 = new HashSet<>(listToFix);
    for(Integer i : listToFix1){
        listToFix.removeAll(i);
        listToFix.add(i);
    }
    System.out.println(listToFix);
}