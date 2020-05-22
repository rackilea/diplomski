Map<MyKey, List<MyType>> map = new TreeMap<>();
// to add
MyType type = ...
MyKey key = ...
List<MyType> myTypes = map.get(key);
if (myTypes == null)
    map.put(key, myTypes = new ArrayList<>());
myTypes.add(type);

// to remove
MyType type = ...
MyKey key = ...
List<MyType> myTypes = map.get(key);
if (myTypes != null) {
    myTypes.remove(myType);
    if (myTypes.isEmpty())
        map.remove(key);
}