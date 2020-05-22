@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public static class LibraryProfile {
    private String libraryId;
    private String libraryName;
    private Book newBookInfo;
    // the trick is NOT to use @XmlElementWrapper here
    private List<Book> currentBooks;
    private String foobar; // just to show a tag after the list 
    // ... accessors
}