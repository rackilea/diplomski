F5Optional<Integer, Integer, Integer, Integer, Integer, Option<Integer>> f5 = new F5Optional<Integer, Integer, Integer, Integer, Integer, Option<Integer>>() {

        @Override
        public Option<Integer> f(Integer a, Integer b, Integer c, Integer d, Integer e) {
            return Option.some(a + b + c + d + e);
        }
    };
    Option<Integer> test2 = b.bindProduct(Option.some(1), Option.some(1), Option.some(1), Option.some(1)).bind(f5.tupleize());
    Assert.assertTrue(new Integer(8).equals(test2.toNull()));

    Option<Integer> nullInteger = Option.none();
    Option<Integer> test3 = b.bindProduct(nullInteger, Option.some(1), Option.some(1), Option.some(1)).bind(f5.tupleize());
    Assert.assertTrue(test3.isNone());