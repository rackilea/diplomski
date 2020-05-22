BiPredicate<ClassA, ClassB> abEquiv =
    equivInt(ClassA::getIntA, ClassB::getIntB)
        .and(equiv(ClassA::getStrA, ClassB::getStrB));

if (abEquiv.test(a, b)) {
    // they're equivalent
}