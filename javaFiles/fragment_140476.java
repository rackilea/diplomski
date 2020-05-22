class IgnoreNoteId implements Predicate<Attr> {

    public boolean test(Attr attr) {
        return !("note".equals(attr.getOwnerElement().getNodeName())
            && "id".equals(attr.getNodeName()));
    }
}