List<ClassA> myList = Arrays.asList(new ClassA(1, "A", true),
                                    new ClassA(2, "B", true));

Set<ClassB> mySet = new HashSet<>(Arrays.asList(new ClassB(1, "A", false),
                                                new ClassB(2, "B", false)));

BiPredicate<ClassA, ClassB> abEquiv =
    equivInt(ClassA::getIntA, ClassB::getIntB)
        .and(equiv(ClassA::getStrA, ClassB::getStrB));

isBijection(myList, mySet, abEquiv)