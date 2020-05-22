/**
 * Gets a `Thingy` instance based on the given `Foo`.
 *
 * @param   foo     the `Foo`, or `null`
 * @return  the new `Thingy` based on the given `Foo`, or `null` if `foo`
 *          is `null`
 * @throws  ThingyException if no `Thingy` can be constructed for the given `Foo`
 */
Thingy getThingyForFoo(Foo foo) {
throws ThingyException
    ExpensiveThingyFactory factory = null;
    if (foo == null) {
        return null;
    }
    factory = getExpensiveThingyFactory();
    try {
        return factory.getThingy(foo);
    }
    finally {
        factory.release();
    }
}