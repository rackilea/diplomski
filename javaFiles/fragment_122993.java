if (a instanceof Type1) {
    ((Type1) a).foo(b, c);
} else (a instanceof Type2) {
    ((Type2) a).foo(b, c);
} else {
    a.foo(b, c); // do a full vtable lookup.
}