public Object getID(Long id)
    {

        String queryString="select id from test where testid= "+id;
        Query query = entityManagerUtil.entityManager.createNativeQuery(queryString);
        List l =  query.list().size();
        if (l>0){ 
          return l.get(0)
        }
        return null;
    }