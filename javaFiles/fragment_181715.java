for(long id : idList){ //idList just holds the IDs of each Product in my ArrayList
    Query query = session.createQuery("select product from Product product where product.id = :id");
    query.setLong("id", id);
    for(Object obj: query.list()){
        listOfConflictingProducts.add((Product)obj);
    }
}