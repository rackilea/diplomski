class A {
    WeekDay weekDay;
    String str;
    Data obj;
}

Map<Integer, A> map = ...;
Iterables.transform(map.values(), new Function<Data, DataDto>() {
            @Override
            public Object apply(String input) {
                return ...;
            }
        });