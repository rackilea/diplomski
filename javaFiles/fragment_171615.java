public static void main(String[] args) {
    List<String> myValues = Arrays.asList("ONE", "TWO", "TWO");
    EnumSet<MyVal> set =
        myValues.stream()
                .map(MyVal::valueOf)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(MyVal.class)));
    System.out.println(set); // prints "[ONE, TWO]"
}