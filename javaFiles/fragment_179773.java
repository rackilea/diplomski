public <T extends Serializable> List<T> load(List<Parameter> params, Class<T> type)
{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        List<T> searchResult;
        session.beginTransaction(); 
        Criteria criteria = createCriteriaFromParams(params);    
        searchResult = criteria.list();  

        return searchResult;
}