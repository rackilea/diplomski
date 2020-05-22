for(long id : idList){ //idList just holds the IDs of each Product in my ArrayList
    Query query = session.createQuery("select product from Product product where product.id = :id");
    query.setLong("id", id);
    List result = query.list();
    for(int i = 0; i < result.size(); i++){
        listOfConflictingProducts.add((Product) result.get(i));
    }
}