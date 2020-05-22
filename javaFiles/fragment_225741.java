public abstract class Element {

    protected Integer childIndex;

    @ManyToOne(fetch=FetchType.LAZY)
    protected CompositeElement parent;