protected <T extends SequenceContainer, T2 extends T>  SortedMap<Integer, T2> noNameFunction(List<T> things, T2 ts) {
    SortedMap<Integer, Object> sortedMap = new TreeMap <> (  );
    for (T t: things) {
        T2 as = ( (T2) t ); 
        sortedMap.put ( as.getSequence(), as.t2OwnMethod() ); // fail to compile, due to the call to t2OwnMethod.
    }
    return sortedMap;
}