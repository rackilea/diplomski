abstract class B {
    public B createCopy(B t);
}
class A extends B {
    public B createCopy(B t) { //Is the copy an A or a different subtype of B? We don't know.
        return new A(t); //copy constructor
    }
}