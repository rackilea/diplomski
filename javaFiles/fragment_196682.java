CriteriaBuilder builder = ...;
CriteriaQuery<BaseEntity> query = ...;
Root<BaseEntity> root = ...;
Root<Entity1> entity1 = builder.treat(root, Entity1.class);
Root<Entity2> entity2 = builder.treat(root, Entity2.class);

query.select(root).where(builder.and(
        builder.lessThan(root.get(BaseEntity_.someDate), new Date()),
        builder.greaterThan(root.get(BaseEntity_.otherDate), new Date()),
        builder.isTrue(root.get(BaseEntity_.flag)),
        builder.equal(entity1.get(Entity1_.someProperty), "foo"),
        builder.equal(entity2.get(Entity2_.otherProperty), "bar")
));