interface ImmutableInterface {
    int getI();
}

class Immutable implements ImmutableInterface ..
class Immutable1 implements ImmutableInterface ..

// The resulting object types are implicitly upcast to
// the common (and named) interface type which is trivially assignable to
// a variable of the same type; no need to worry about subtypes here.
ImmutableInterface immutable=Immutable.create(1);
ImmutableInterface immutable1=Immutable1.create(1);
immutable1 = immutable;