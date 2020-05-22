enum Element {

    interface TransitionStrategy {
       Element getNextElement (Element myself, Element nextElement);
    }

    static class NextOnBStrategy implements TransitionStrategy {
       Element getNextElement (Element myself, Element nextElement) {
            if(nextElement.getGroup() == Group.B) {
                return nextElement;
            } else {
                return myself;
            }
        }                
    }

    // other strategies

    X(Group.A, new NextOnBStrategy ()),
    Y(Group.B, new NextOnAStrategy ()),
    Z(Group.C, new NextOnAStrategy ());

    Group group;
    TransitionStrategy strategy;

    Element(Group group, TransitionStrategy strategy) {
        this.group=group; 
        this.strategy=strategy;
    };

    // ...


    public Element getNextElement(Element nextElement) {
       return this.strategy.getNextElement (this, nextElement);
    }

}