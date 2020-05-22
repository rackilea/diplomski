final ConcurrentMap<String,Object> map = new ConcurrentHashMap<>();
final Object old = map.putIfAbsent("hello", "world");

if (old != null) {

    // The value was already present and has not been modified
    // by the call.

} else {

    // There was no prior entry, and "world" has been assigned
    // as value for key "hello"
}