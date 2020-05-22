public BookModel(Book book) {
    this.book = book;
    try {
        this.authorName = (AuthorLocalServiceUtil.getAuthor(book.getAuthorId())).getAuthorName();
    } catch (PortalException | SystemException e) {
        throw new RuntimeException(e);
    }
}