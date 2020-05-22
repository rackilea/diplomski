final DetachedCriteria criteria = DetachedCriteria.forClass(ActivePropertyView.class);
criteria.add(Restrictions.eq("featured", true));
List<ActivePropertyView> result = entityManager.execute(
     new HibernateCallback<List<ActivePropertyView>>() {
         @Override
         public List<ActivePropertyView> doInHibernate(Session session) 
                                         throws HibernateException,SQLException {
                 return criteria.getExecutableCriteria(session).setMaxResults(5).list();
         }
     });
return result;