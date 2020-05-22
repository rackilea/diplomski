private static <K, V> Map<K, List<V>> transformToMapOfListInOneStep(
        List<SomeBean> paginationResult) {

    return paginationResult.stream()
        .collect(Collectors.toMap(
            SomeBean::getK, 
            someBean -> new ArrayList<>(someBean.getV()), 
            (v1, v2) -> { v1.addAll(v2); return v1; }));
}