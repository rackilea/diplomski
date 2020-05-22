Session session = entityManager.unwrap( Session.class );

Book book = session
    .bySimpleNaturalId( Book.class )
    .load( "978-9730228236" );

LOGGER.info( "Book details: {}", book.getProperties() );

book.setProperties(
    JacksonUtil.toJsonNode(
        "{" +
        "   \"title\": \"High-Performance Java Persistence\"," +
        "   \"author\": \"Vlad Mihalcea\"," +
        "   \"publisher\": \"Amazon\"," +
        "   \"price\": 44.99," +
        "   \"url\": \"https://www.amazon.com/High-Performance-Java-Persistence-Vlad-Mihalcea/dp/973022823X/\"" +
        "}"
    )
);