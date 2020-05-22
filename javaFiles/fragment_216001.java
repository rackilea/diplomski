V oldValue = get(key);
V newValue = (oldValue == null) ? value :
   remappingFunction.apply(oldValue, value);
if(newValue == null) {
  remove(key);
} else {
  put(key, newValue);
}