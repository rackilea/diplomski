final Function<String, Double> fn = new Function<String, Double>()
{
    @Override
    public Double apply(final String input)
    {
        return Double.parseDouble(input);
    }
};

// with S the original ArrayList<String>

final List<Double> D = Lists.transform(S, fn);