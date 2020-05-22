public static <E> LinkedSequence<E> concat(LinkedSequence<E> s1, LinkedSequence<E> s2) {
    if(s1 == null || s2 == null) {
        return null;
    }
    LinkedSequence<E> concat = new LinkedSequence<>();
    concat.addAll(s1);
    concat.addAll(s2); 
    return concat;
}