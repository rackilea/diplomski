public static int[] eliminateDuplicates(int[] numberList) {

    Set<Integer> noDups = new HashSet<Integer>();

    for (int num : numberList)  
        noDups.add(num);

    int[] noDuplicateList = new int[noDups.size()];

    Iterator<Integer> iter = noDups.iterator();
    for (int i=0; i<noDuplicateList.length && iter.hasNext();i++)
         noDuplicateList[i]=iter.next();

    return noDuplicateList;
}