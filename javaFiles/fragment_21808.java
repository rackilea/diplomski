Criteria query = getSession().createCriteria(EntityClass.class);
EntityClass example = new EntityClass();
example.setEmbedded(embedded);
query.add(Example.create(example).excludeNone()
    .excludeProperty("id").excludeProperty("other"));
return (EntityClass) query.uniqueResult();