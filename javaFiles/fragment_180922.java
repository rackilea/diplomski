public abstract class Composite implements Element {

    protected List<Element> elements;

    public void accept(Visitor visitor) {
        for(Element element: elements) {
            element.accept(visitor);
        }
    }

}