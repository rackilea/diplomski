protected <T extends SequenceContainer, T2 extends T, X>  SortedMap<Integer, X> noNameFunction(List<T> things, T2 ts, Function<T2, X> valueFunction) {
    SortedMap<Integer, Object> sortedMap = new TreeMap <> (  );
    for (T t: things) {
        T2 as = ( (T2) t ); 
        sortedMap.put ( as.getSequence(), valueFunction.apply(as)); // fail to compile, due to the call to t2OwnMethod.
    }
    return sortedMap;
}