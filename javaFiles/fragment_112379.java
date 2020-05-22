class Derived extends Base {
    // Previous declarations omitted.
    void useSuper() { Derived.use(super); }
    void useThis() { Derived.use(this); }

    static void main() {
        Derived instance = new Derived();
        instance.useThis();
        instance.useSuper();
    }
}