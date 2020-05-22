CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<ReviewItem> query = cb.createQuery(ReviewItem.class);
Root<Product> productRoot = query.from(Product.class);
...
Join<Product, Review> reviewJoin = productRoot.join("productReviews", JoinType.LEFT);

query.select(cb.construct(ReviewItem.class,        
                productRoot.get("productid"),
                productRoot.get("productname"),
                cb.avg(reviewJoin.get("stars")),
                cb.countDistinct(reviewJoin)
        ))
        .where(cb.and(predicates.toArray(new Predicate[predicates.size()])))
        .groupBy(productRoot.get("productid"), productRoot.get("productname"))
        .orderBy(cb.desc(cb.avg(reviewJoin.get("stars"))));

List<ReviewItem> x = entityManager.createQuery(query).getResultList();