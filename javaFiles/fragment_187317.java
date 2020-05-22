TBook book = T_BOOK.as("b");
TAuthor author = T_AUTHOR.as("a");

create.select(author.ID, book.ID)
      .from(author)
      .join(book).on(author.ID.equal(book.AUTHOR_ID))