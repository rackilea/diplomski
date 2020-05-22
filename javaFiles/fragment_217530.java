insertOrUpdate(key) {
    while(true) {
        var foo = map.get(key);
        if (foo == null) {
            if (map.putIfAbsent(key, new Foo())) break;
        } else {
            if (map.replace(key, foo, modifyFoo(foo))) break;
        }
    }
}