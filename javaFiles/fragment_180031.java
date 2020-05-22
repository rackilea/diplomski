V oldValue = map.get(key);
V newValue = (oldValue == null) ? value :
          remappingFunction.apply(oldValue, value);
if (newValue == null)
    map.remove(key);
else
    map.put(key, newValue);