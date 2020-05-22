Kid[] kids = Kid.getSimpleArray();
Kid[] filteredKids = Arrays.stream(kids).filter(Kid::hasToy).toArray(Kid[]::new);
String names = IntStream.range(0, filteredKids.length)
                        .mapToObj(i -> i + "." + filteredKids[i].getSurname())
                        .collect(Collectors.joining(", ");
out.println(names);