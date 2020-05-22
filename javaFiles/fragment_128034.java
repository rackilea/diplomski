Stream<List> s1 = outer.stream();
Stream s2 = s1.flatMap(inner -> inner.stream());
Stream s3 = s2.map(obj -> obj.hashCode() % 2 == 0);
Stream s4 = s3.filter(b -> !b); // compiler error
Optional opt = s4.findAny();
boolean b = opt.isPresent();