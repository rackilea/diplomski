public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set){
    //add your code here
    for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();){
        //System.out.println(nr);
        int nr = iterator.next();
        if (nr > 10){
            iterator.remove();
        }
    }
    return set;
}