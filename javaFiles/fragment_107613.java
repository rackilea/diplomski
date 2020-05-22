A<String> specificA = ...;

// So the "specificA" can load "String" objects. Then this is fine:
A<? extends Object> a = specificA;
Object s = a.typeOfX.cast(s);

// But here's the error: "s" is only an Object, and not a String!
a.load(s);