List<Long> values = new ArrayList<Long>();
values.add(1L);
values.add(2L);
values.add(3L);

String hql = "from lxr_reportsauto_customcolumns  where column_id in (:columnIds)";
Query query = session.createQuery(hql);
query.setParameterList("columnIds", values);