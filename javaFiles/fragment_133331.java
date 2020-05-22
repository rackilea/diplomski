String hql = String.format("FROM %s obj where 1=1 ",c.getSimpleName());
for (int i = 0; i < tempList.size(); i++) {
    hql += " "+operator+" :collection" + i + " = some elements(obj.emailAddressTags)";
}

Query query = session.createQuery(hql);
for (int i = 0; i < tempList.size(); i++) {
    query.setParameter("collection" + i, tempList.get(i));
}
list = query.list();