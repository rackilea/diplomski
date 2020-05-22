final AtomicInteger ai = new AtomicInteger();
Kid[] kids = Kid.getSimpleArray();
String names = Stream.of(kids)
                .filter(Kid::hasToy)
                .map(x -> ai.incrementAndGet() + "." + x.getSurname())
                .collect(Collectors.joining(", "));
out.println(names);