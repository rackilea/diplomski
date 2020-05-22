function createIterator(iterable)
{
    var iterator = iterable.iterator();
    while (iterator.hasNext())
        yield iterator.next();
    throw StopIteration;
}

for (var item in createIterator(webapi.getItems()))
{
    //do something with item [..]
}