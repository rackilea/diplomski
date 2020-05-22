Query<Fruits> query = datastore.createQuery(Fruits.class);
Iterator<Fruits> fruitIterator = fruitList .iterator();
CriteriaContainer orQuery = query.or();
while(fruitIterator.hasNext()) {
      Fruits fruit = fruitIterator.next();
      orQuery.add(query.and(query.criteria("id").equal(fruit.getId()), query.criteria("categories").equal(fruit.getCategories())));
 }