Map<MyKey, Set<MyEnum>> map = myObjs.stream()
        .collect(Collectors.groupingBy(
                    MyType::getMyKey,
                    Collectors.reducing(
                        EnumSet.noneOf(MyEnum.class), // <-- EnumSet
                        MyType::getMyEnums,
                        (a, b) -> {
                            EnumSet<MyEnum> c = EnumSet.copyOf(a); // <-- copy
                            c.addAll(b);
                            return c;
                        })));