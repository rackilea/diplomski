public abstract class JpaDaoTest<K,E> {

    abstract protected E getEntity();
    abstract protected JpaDao getDAO();

    @Test
    public void testPersistCreatesEntity()
    {
         JpaDao dao = getDAO();
         dao.persist(getEntity());
         // assert
     }
}