public class Foo {

    @ManyToOne
    @JoinColumn(name = "bar_id")
    private Bar bar;

    @ManyToMany
    @JoinTable(...)
    private Set<Bar> bars = new HashSet<Bar>();

    // no getter, setter or any other method for the bars collection

    public void setBar(Bar bar) {
        this.bar = bar;
        this.bars.clear();
        if (bar != null) {
            this.bars.add(bar);
        }
    }
}