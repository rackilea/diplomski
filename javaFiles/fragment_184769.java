Map<X,Y> newMap = new HashMap<X,Y>(map);
newMap.keySet().removeAll(B);  // remove keys in the set B

for (Map.Entry<X, Y> entry : newMap.entrySet()) {
    entry.setValue(someMethod(entry.getValue());
}

map.putAll(newMap);