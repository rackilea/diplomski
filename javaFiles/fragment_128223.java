Query categoryQuery = queryBuilder.keyword().onField( "category.__Id" ).matching( <some ID> ).createQuery()
Query booleanJunction = queryBuilder.bool()
    .must( categoryQuery )
    .must( <some other query> )
    .must( <some other query> )
    .createQuery()
FullTextQuery fullTextQuery = fullTextEntityManager.createQuery( booleanJunction, Ad.class );