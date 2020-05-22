boolean contains = false;
Iterator<MyObject> = list.iterator();
while(iterator.hasNext() && !contains) {
    contains = iterator.next().getField().equals(someValue);
}

return contains;