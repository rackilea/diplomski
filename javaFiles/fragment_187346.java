@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "document")
@LazyCollection(LazyCollectionOption.EXTRA)
@Sort(type = SortType.NATURAL, comparator = DocumentPersonCc.class)
public SortedSet<DocumentPersonCc> getDocumentPersonCcs() {
    return this.documentPersonCcs;
}