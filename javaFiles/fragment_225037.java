Object[] r = (Object[]) em.createNativeQuery(
    "select id,title,shorttitle,datestamp,body,true as published, ts_headline(body,q,'ShortWord=0') as headline, type from articles,to_tsquery('english',?) as q where idxfti @@ q order by ts_rank(idxfti,q) desc","ArticleWithHeadline")
    .setParameter(...).getSingleResult();

Article a = (Article) r[0];
a.setHeadline((String) r[1]);