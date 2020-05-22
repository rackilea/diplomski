final Function extractB = new Function<A, B>()
{
    @Override
    public B apply(final A input)
    {
        return input.getB();
    }
}

// And then:

final List<B> listOfB = Lists.transform(listOfA, extractB);