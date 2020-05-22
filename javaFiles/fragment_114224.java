List<Container> containersList = Arrays.asList(new Container("A"), new Container("B"), new Container("A"), new Container("A"), new Container("B"));

String[] result =
        StreamEx.of(containersList)
                .map(Container::getLetter)
                .groupRuns(Object::equals)
                .collect(MoreCollectors.pairing(
                    MoreCollectors.flatMapping(List::stream, Collectors.joining()),
                    MoreCollectors.mapping(l -> l.get(0), Collectors.joining()),
                    (s1, s2) -> new String[] { s1, s2 }
                ));

System.out.println(result[0]);
System.out.println(result[1]);