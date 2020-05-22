@Test
public void shouldFindAliasedValue() {

    Class<?> actual = AnnotatedElementUtils.findMergedAnnotation(C.class, A.class).value();

    then(actual).isEqualTo(D.class);
}