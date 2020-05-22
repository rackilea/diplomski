<T> void bind3(Class<T> clazz) { ... }
<T> void bind4(T obj) { ... }

binder.bind3(String.class); // compiles
binder.bind4(String.class); // compiles

binder.bind3("") // doesn't compile
binder.bind4("") // compiles