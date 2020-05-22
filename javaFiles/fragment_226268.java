public void foo(@NonNull String bar) {
    Objects.requireNonNull(bar);
}

/** Trick the Java flow analysis to allow passing <code>null</code>
 *  for @Nonnull parameters. 
 */
@SuppressWarnings("null")
public static <T> T giveNull() {
    return null;
}

@Test(expected = NullPointerException.class)
public void testFoo() {
    foo(giveNull());
}