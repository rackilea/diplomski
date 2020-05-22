Stream<List<?>> s1 = outer.stream();
Stream<?> s2 = s1.flatMap(inner -> inner.stream());
Stream<Boolean> s3 = s2.map(obj -> obj.hashCode() % 2 == 0);
Stream<Boolean> s4 = s3.filter(b -> !b); // compiles OK
Optional<Boolean> opt = s4.findAny();
boolean b = opt.isPresent();