public Pair<A, ? extends Marker> getTarget()
{
    A a = new A();
    C c = new C();
    return new Pair<>(a, c);
}