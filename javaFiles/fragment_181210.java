Metamodel meta = entityManager.getMetamodel();
EntityType<User> user_ = meta.entity(User.class);

CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaUpdate<User> update = cb.createCriteriaUpdate(User.class);

Root e = update.from(User.class);

for( Attribute<? super User, ?> attr : user_.getAttributes() ) {
      if (map.containsKey(attr.getName())) {
          update.set(attr, map.get(attr));
      }
}

update.where(cb.equal(e.get("id"), idOfUser));
entityManager.createQuery(update).executeUpdate();