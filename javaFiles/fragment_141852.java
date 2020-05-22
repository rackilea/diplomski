FullTextSession fts = Search.getFullTextSession(getSessionFactory().getCurrentSession());

Query q = fts.getSearchFactory().buildQueryBuilder()
    .forEntity(Offer.class).get()
    .keyword()
    .onField("id")
    .matching(myId)
    .createQuery();
Object[] dId = (Object[]) fts.createFullTextQuery(q, Offer.class)
    .setProjection(ProjectionConstants.DOCUMENT_ID)
    .uniqueResult();

if(dId != null){

    IndexReader indexReader = fts.getSearchFactory().getIndexReaderAccessor().open(Offer.class);

    TermFreqVector freq = indexReader.getTermFreqVector((Integer) dId[0], "description");

}