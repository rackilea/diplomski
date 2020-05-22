CriteriaQuery<User> query = cb.createQuery(User.class);
Root<User> root = query.from(User.class);
query.select(root);

Subquery<Long> subquery = query.subquery(Long.class);
Root<User> subroot = subquery.from(User.class);
SetJoin<User, Permission> join = subroot.join("permissions");
subquery.select(subroot.get("id")).where(cb.equal(join, Permission.RULE_THEM_ALL));

query.where(root.get("id").in(subquery).not());