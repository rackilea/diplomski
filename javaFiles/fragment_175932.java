UDF2 my_udf2 = new UDF2<WrappedArray<String>, WrappedArray<String>, String>() {
    public String call(WrappedArray<String> a1, WrappedArray a2) throws Exception {
        ArrayList<String> l1 = new ArrayList(JavaConverters
            .asJavaCollectionConverter(a1)
            .asJavaCollection());
        ArrayList<String> l2 = new ArrayList(JavaConverters
            .asJavaCollectionConverter(a2)
            .asJavaCollection());
        return l1.stream().collect(Collectors.joining(",")) +
             " AND " +
             l2.stream().collect(Collectors.joining(","));
    }
};