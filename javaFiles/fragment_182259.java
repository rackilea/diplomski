for (V oldValue; (oldValue = map.get(key)) != null; ) {
    V newValue = remappingFunction.apply(key, oldValue);
    if ((newValue == null)
        ? map.remove(key, oldValue)
        : map.replace(key, oldValue, newValue))
     return newValue;
 }
 return null;