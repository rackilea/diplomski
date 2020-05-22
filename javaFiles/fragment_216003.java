V oldValue = containsKey(key) ? get(key) : null;
V newValue = (oldValue == null) ? value :
   oldValue + " and " + value; //oldValue would be s and value would be s2
if(newValue == null) {
  remove(key);
} else {
  put(key, newValue);
}