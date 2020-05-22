// 1) MainQuery
// Create the FROM
Root<PubThread> rootPubThread = mainQuery.from(PubThread.class);
// Create the JOIN from the first select: join-chaining. You only need the return for ordering. e.g. cq.orderBy(cb.asc(categoryJoin.get(Pub_.title)));
Join<Pub, PubCategory> categoryJoin = rootPubThread.join(PubThread_.pups).join(Pub_.pubCategory);
// Create the WHERE
mainQuery.where(criteriaBuilder.not(criteriaBuilder.equal(rootPubThread.get(PubThread_.id), threadId)));
// Create the SELECT, at last
mainQuery.select(rootPubThread).distinct(true);

// 2) Subquery
Subquery<PubThread> subquery = mainQuery.subquery(PubThread.class); 
Root<PubThread> rootPubThreadSub = subquery.from(PubThread.class); 
//subquery.where(criteriaBuilder.equal(rootPubThread.get(PubThread_.id), threadId));
Join<Pub, PubCategory> categoryJoinSub = rootPubThreadSub.join(PubThread_.pups).join(Pub_.pubCategory);
subquery.select(rootPubThreadSub);

//Predicate correlatePredicate = criteriaBuilder.equal(rootPubThreadSub.get(PubThread_.id), rootPubThread);
Predicate correlatePredicate = criteriaBuilder.and(
        //criteriaBuilder.equal(rootPubThreadSub.get(PubThread_.id), rootPubThread),
        criteriaBuilder.equal(categoryJoinSub.get(PubCategory_.id), categoryJoin.get(PubCategory_.id)),

        criteriaBuilder.equal(rootPubThreadSub.get(PubThread_.id), threadId)
        );
subquery.where(correlatePredicate);     

//Predicate correlatePredicate = criteriaBuilder.equal(rootPubThreadSub.get(PubThread_.id), rootPubThread);
Predicate mainPredicate = criteriaBuilder.and(
        criteriaBuilder.not(criteriaBuilder.equal(rootPubThread.get(PubThread_.id), threadId)),
        criteriaBuilder.exists(subquery)
        );
//cq.where(criteriaBuilder.exists(subquery));
mainQuery.where(mainPredicate);


TypedQuery<PubThread> typedQuery = em.createQuery(mainQuery);
List<PubThread> otherPubThreads = typedQuery.getResultList();