List<AnotherObject> anotherList = list.stream()
        .collect(Collectors.groupingBy(
                SomeObject::getVar1, Collectors.mapping(
                        SomeObject::getVar2, Collectors.toList())))
        .entrySet().stream()
        .map(e -> new AnotherObject(e.getKey(), e.getValue()))
        .collect(Collectors.toList());