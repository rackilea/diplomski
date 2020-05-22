Book book = new Book();
book.setIsbn( "978-9730228236" );
book.setProperties(
    JacksonUtil.toJsonNode(
        "{" +
        "   \"title\": \"High-Performance Java Persistence\"," +
        "   \"author\": \"Vlad Mihalcea\"," +
        "   \"publisher\": \"Amazon\"," +
        "   \"price\": 44.99" +
        "}"
    )
);

entityManager.persist( book );