Collection<Object> values = map.get(key);
checkState(values.size() == 2, String.format("Found %d values for key %s", values.size(), key));

return values.iterator().next(); // to get the first

Iterator<Object> it = values.iterator();
it.next(); // move the pointer to the second object
return it.next(); // get the second object