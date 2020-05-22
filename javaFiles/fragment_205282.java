List<Object> list = ...; // create new list and fill it
Object someObj = new Object();

for (Object obj : list) { // iterating list
    list.add(someObj); // modifying list while it's being iterated
}