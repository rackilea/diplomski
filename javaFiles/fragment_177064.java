class Controller {
    A a;
    B b;
    C c;

    private void injectControll() {
        a.registerListener(b); // a.passTo(b);
        b.registerListener(c);
        c.registerListener(a);
    }