List<?> list = new ArrayList();
List<MyConcreteType> collect1 = 
    list.stream()
        .filter((o -> o instanceof MyConcreteType))
        .map(s-> (MyConcreteType) s)
        .collect(Collectors.toList());