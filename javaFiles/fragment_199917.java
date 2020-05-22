public static <T, P> List<P> listConvertor(List<T> inputList, Class<P> outputClass) {
    List<P> outputList = new ArrayList<P>(inputList.size());
    for (T t : inputList) {
        if( !outputClass.isInstance(t) )
            throw new ClassCastException("Faked CCException");
        @SuppressWarnings("unchecked")
        P p = (P) t;
        outputList.add(p);
    }

    return outputList;
}