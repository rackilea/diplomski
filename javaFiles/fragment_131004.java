private static <T extends Comparable<? super T>> boolean isSorted(List<T> list){
    for (int i = 0; i < list.size()-1; i++) {
        if(list.get(i).compareTo(list.get(i+1))> 0){
            return false;
        }
    }
    return true;
}


boolean isSorted = isSorted(list);
System.out.println(isSorted);