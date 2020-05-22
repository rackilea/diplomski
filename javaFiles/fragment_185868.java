<T> void bind(Class<T> clazz, Type<T> type) { ... }
<T> void bind2(T obj, Type<T> type) { ... }

binder.bind(String.class, new Type<String>("x")); // compiles
binder.bind2(String.class, new Type<String>("x")); // doesn't compile

binder.bind("", new Type<String>("x")) // doesn't compile
binder.bind2("", new Type<String>("x")) // compiles