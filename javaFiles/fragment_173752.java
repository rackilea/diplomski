String namesSeparatedBySlash = Joiner
    .on("/")
    .join(
         Lists.transform(list, new Function<MyClass,String>() {
            public String apply(MyClass obj) {
                return obj.name;
            }
        })
    );