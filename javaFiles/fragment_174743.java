Criteria c = session.createCriteria(Item.class, i);
...
if (!items.isEmpty()) {
    c.add(Restrictions.in("i.name", items));
}
return c.list();