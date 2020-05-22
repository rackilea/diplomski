Set<String> set = ...
...build the set...

// Freeze the set
set = Collections.unmodifiableSet(set);

// Now you can safely pass it elsewhere
obj.setData (set);