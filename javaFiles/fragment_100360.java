class ChildSection {
    private final Section parent;
    private final List<Section> sections = new ArraysList<Section>();

    public void add(Section section) {
        sections.add(section);
        section.setParent(parent);
    }
}