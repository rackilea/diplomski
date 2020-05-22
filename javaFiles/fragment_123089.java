public static Set<String> findDuplicates(List<String> listContainingDuplicates)
{ 
    final Set<String> setToReturn = new HashSet<>();
    final Set<String> set1 = new HashSet<>();
    for (String myString : listContainingDuplicates)
    {
        if (!set1.add(myString))
            setToReturn.add(myString);
    }
    System.out.println("Unique months: " +set1);
    return setToReturn;
}