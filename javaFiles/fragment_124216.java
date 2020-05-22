public static final Map<String, FooBar> mapEnum;

static {
    mapEnum = Arrays.stream(FooBar.values())
            .collect(Collectors.toMap(FooBar::getName, Function.identity()));
    mapEnum.put("xx", FooBar.A);
    // ...
}