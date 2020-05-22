Criteria crit = session.createCriteria(Cat.class);
crit.createAlias("owner", "ownerAlias");
crit.createAlias("species", "speciesAlias");
crit.add(Restrictions.eq("ownerAlias.id", ownerId);
crit.add(Restrictions.eq("speciesAlias.id", speciesId);
return crit.list();