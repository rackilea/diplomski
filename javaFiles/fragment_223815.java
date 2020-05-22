final List tmp = new ArrayList();
Kid[] kids = Kid.getSimpleArray();
String names = Stream.of(kids)
                .filter(Kid::hasToy)
                .peek(x -> tmp.add(1))
                .map(x -> tmp.size() + "." + x.getSurname())
                .collect(Collectors.joining(", "));
out.println(names);