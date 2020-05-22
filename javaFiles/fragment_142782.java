CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Entity> criteria = cb.createQuery(Entity.class);
Root<Entity> entity = criteria.from(Entity.class);
MapJoin<Entity, String, String> mapJoin = entity.joinMap(Entity_.myMap);
criteria.where(cb.and(cb.equal(mapJoin.key(), "myKey"),
                      cb.equal(mapJoin.value(), "myValue")));