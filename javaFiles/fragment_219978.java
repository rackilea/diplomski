//populated
    List<MyClass> yourList;

    List<Integer> listbyAttribute = FluentIterable.from(yourList)
            .transform(new Function<MyClass, Integer>() {
        public Integer apply(MyClass f) {
            return f.getAttribute1();
        }
    }).toList();