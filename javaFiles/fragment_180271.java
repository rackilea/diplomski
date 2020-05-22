Iterator<String> iterator = foo.iterator();

// Handle the first item specially
if (!iterator.hasNext()) {
    throw new SomeException("foo shouldn't be empty");
}
SomeResult result = new SomeResult(iterator.next());

// Now deal with the rest
while (iterator.hasNext())
{
    String item = iterator.next();
    result.addItem(item);
}