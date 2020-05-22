Test[] a = Stream.generate(() -> new Test(x++, 0))
            .limit(10)
            .map((Test v) -> {
                v.a = v.a * 2;
                return v;
            })
            .toArray(Test[]::new);