methods()
    .that()
    .areAnnotatedWith(A.class)
    .should()
    .beAnnotatedWith(B.class)
    .orShould()
    .beDeclaredInClassesThat()
    .areAnnotatedWith(B.class);