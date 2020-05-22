public static <T> boolean subSequence(ArrayList<T> s1, ArrayList<T> s2) {
    Iterator<T> itr1 = s1.iterator();
    Iterator<T> itr2 = s2.iterator();

    while (itr1.hasNext()) {
        T itemFrom1 = itr1.next();
        T itemFrom2;
        do {
            if( ! itr2.hasNext()){
                return false;
            }
            itemFrom2 = itr2.next();
        } while( ! itemFrom1.equals(itemFrom2));
    }
    return true;    
}