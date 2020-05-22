class Container<B extends Billing,E extends Employee, L extends Level> {

    B billing;

    E employee;

    L level;

    public Container(B b, E e, L l) {
        billing = b;
        employee = e;
        level = l;
    }

    // ... getters only!
}