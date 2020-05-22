V oldValue = containsKey(key) ? get(key) : null;
V newValue = (oldValue == null) ? value :
   remappingFunction.apply(oldValue, value);
if(newValue == null) {
  remove(key);
} else {
  put(key, newValue);
}