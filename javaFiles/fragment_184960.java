@OneToMany(mappedBy = "book", fetch = LAZY")
private Set<Page> pages;

public Set<Page> getPages() {
    return pages;
}