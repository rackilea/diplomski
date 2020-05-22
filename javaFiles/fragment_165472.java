Result<Record> result =
create.select()
      .from(BOOK)
      .join(AUTHOR).
      .on(AUTHOR.AUTHOR_ID.equal(BOOK.AUTHOR_ID))
      .fetch();

BookRecord book = result.into(BOOK);
AuthorRecord author = result.into(AUTHOR);