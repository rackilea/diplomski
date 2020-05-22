for (A<? extends S> a : map.values())
{
    if (a.typeOfX.isAssignableFrom(superx.getClass()))
    {
        // This call is safe as of the check done above:
        @SuppressWarnings("unchecked")
        A<Object> castA = (A<Object>) a;
        castA.load(superx);
    }
}