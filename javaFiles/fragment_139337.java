public class Foo implements MouseListener {
    ...
    private Component c;
    public void registerWithComponent(final Component c) {
        c.addMouseListener(this);
        this.c = c;
    }
}