class Derived<T extends Printable> extends Base<T> {
    ...
    @Override
    public void print() {
        ((Printable)getObject()).print();
    }
}