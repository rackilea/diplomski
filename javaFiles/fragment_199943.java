Map<MyKey, Set<MyEnum>> map = myObjs.stream()
        .collect(Collectors.groupingBy(
                    MyType::getMyKey,
                    Collector.of(
                            () -> EnumSet.noneOf(MyEnum.class),
                            (r, myObj) -> r.addAll(myObj.getMyEnums()),
                            (r1, r2) -> { r1.addAll(r2); return r1; }
                    )));