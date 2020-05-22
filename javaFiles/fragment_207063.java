public ListElementReceiver() {
    this(new ArrayList<>());
}

public ListElementReceiver(List<Element> elements) {
    this.elements = elements;
    elementIter = elements.iterator();
}