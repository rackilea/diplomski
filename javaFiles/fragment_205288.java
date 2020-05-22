String sql = create.select(
                        fieldByName("BOOK","TITLE"), 
                        fieldByName("AUTHOR","FIRST_NAME"), 
                        fieldByName("AUTHOR","LAST_NAME"))
                   .from(tableByName("BOOK"))
                   .join(tableByName("AUTHOR"))
                   .on(fieldByName("BOOK", "AUTHOR_ID").eq(
                        fieldByName("AUTHOR", "ID")))
                   .where(fieldByName("BOOK", "PUBLISHED_IN").eq(1948))
                   .getSQL();