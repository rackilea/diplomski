em.getTransaction().begin();
try
{
    // do something with the entityManager
    em.getTransaction().commit();
}
catch(MyException ex)
{
    em.getTransaction().rollback();
}