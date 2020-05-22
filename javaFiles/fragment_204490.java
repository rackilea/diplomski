public static <E> List<E> mergeArray(@SuppressWarnings("unchecked") List<? extends E> ...list) {
    List<E> result = new ArrayList<E>(); 
    for(List<? extends E> temp : list) {
        result.addAll(temp); 
    }
    return result; 
}