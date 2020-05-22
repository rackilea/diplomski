Object a, b, c;
....
Optional.ofNullable(a) // null-check for 'a'
    .map(x -> b) // null-check for 'b'
    .map(x -> c) // null-check for 'c'
    .ifPresent(x -> ...) // do something with a,b,c