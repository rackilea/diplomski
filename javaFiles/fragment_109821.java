//query creation
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Document> documentQuery = builder.createQuery(Document.class);
    Root<Document> root = documentQuery.from(Document.class);

    //parameter list for where
    List<Predicate> predicateList = new ArrayList<Predicate>();

    //doing the join: pass the translations reference (list <Translations) that exists in the document model.
    Join<Document, Translation> documentTranslationJoin = root.join("translations");
   //I get the ids of the languages ​​associated with the translations found in the join
    Path<Long> translationLanguageId = documentTranslationJoin.get("language");
    //I passed the ids of the languages ​​that I want to find translations
    List<Long> ids = new ArrayList<>();
    ids.add(1);
    ids.add(2);
    ids.add(3);

    //considers languages ​​of translations
    Predicate predicateTranslationId = builder.isTrue(translationLanguageId.in(ids));
    //I passed the ids of the languages ​​that will be the where looking for the translations that have the ids of the languages ​​that I want to see
    predicateList.add(predicateTranslationId);


    //considers title of document
    Predicate titlePredicate = builder.like(root.get("title"),"%documento%");
    predicateList.add(titlePredicate);

    //where
    Predicate[] predicates = new Predicate[predicateList.size()];
    predicateList.toArray(predicates);
    documentQuery.where(predicates);

    //execution of the query with its parameters
    TypedQuery<Document> query = this.entityManager.createQuery(documentQuery);

    query.setFirstResult(0);
    query.setMaxResults(8);

    //results
    List<Document> documents = query.getResultList();