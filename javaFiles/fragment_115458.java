FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Customer.class).get();
TermMatchingContext onFields = qb.keyword().onFields("customer.shortDescription",  "customer.longDescription");

BooleanJunction<BooleanJunction> bool = qb.bool();
org.apache.lucene.search.Query query = null;
String[] searchTerms = searchQuery.split("\\s+");
for (int j = 0; j < searchTerms.length; j++) {
   String currentTerm = searchTerms[j];
   bool.must(onFields.matching(currentTerm).createQuery());
}

query = bool.createQuery();

FullTextQuery persistenceQuery = fullTextEntityManager.createFullTextQuery(query, Customer.class);
resultList = persistenceQuery.getResultList();