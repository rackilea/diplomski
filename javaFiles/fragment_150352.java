Comparator<Parent> c=Comparator.comparing(Parent::getAttrib1)
        .thenComparing(Parent::getAttrib2)
        .thenComparing(Parent::getAttrib3)
        // …
        .thenComparing(Parent::getAttrib19)
        .thenComparing(Parent::getAttrib20);