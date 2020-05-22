public static void main(String[] args) throws Exception {
    String str = "1,2,3,4,5,6";
    Function<Object, Object> splitByComma = s -> ((String) s).split(",");
    Function<Object, Object> convertToInt = tokens -> Stream.of((String[]) tokens).map(Integer::valueOf).toArray(Integer[]::new);
    Function<Object, Object> findMax = ints -> Stream.of((Integer[]) ints).max(Integer::compare).get();
    Integer max = (Integer) combineFunctions(splitByComma, convertToInt, findMax).apply(str);
    System.out.println(max);
}

@SafeVarargs
private static Function<Object, Object> combineFunctions(Function<Object, Object>... functions) {
    return Arrays.stream(functions)
                 .reduce(Function::andThen)
                 .orElseThrow(() -> new IllegalArgumentException("No functions to combine"));
}