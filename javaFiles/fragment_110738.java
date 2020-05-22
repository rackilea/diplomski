public <T> List<T> getTopLevelItems(Class<T> clazz) throws Exception 
{
    EntityManager em = JPABase.createElementEntityManager();
    Criteria<T> criteria = new Criteria(em, clazz.getClass());
    criteria.addEquals("levelNum", "1");
    return criteria.search();    
}