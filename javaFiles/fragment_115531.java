public static final Predicate getByCodeAndName(
    final String sCode,
    final String sName) {
    QFoo foo = QFooVal.foo;
    return foo.id.code.eq(sCode)
        .and(foo.name.eq(sName));
}