abstract class Either<A, B> { }
class Left<A, B> extends Either<A, B> {
    public A left_value;
    public Left(A a) { left_value = a; }
}
class Right<A, B> extends Either<A, B> {
    public B right_value;
    public Right(B b) { right_value = b; }
}

// to construct it
Either<A, B> foo = new Left<A, B>(some_A_value);
Either<A, B> bar = new Right<A, B>(some_B_value);

// to deconstruct it
if (foo instanceof Left) {
    Left<A, B> foo_left = (Left<A, B>)foo;
    // do stuff with foo_left.a
} else if (foo instanceof Right) {
    Right<A, B> foo_right = (Right<A, B>)foo;
    // do stuff with foo_right.b
}