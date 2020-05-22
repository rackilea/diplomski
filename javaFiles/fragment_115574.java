// Library method - cannot refactor the parameter type
public void printAll(List<?> list)
{
    for (Object each : list)
    {
        System.out.println(each);
    }
}

ImmutableList<Integer> immutableList = Lists.immutable.with(1, 2, 3);
List<Integer> castList = immutableList.castToList();
printAll(castList);
// also works
printAll((List<?>) immutableList);

// throws UnsupportedOperationException
castList.add(4);