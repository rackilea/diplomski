@Resource
UserTransaction ut;
...
public void delete(E entity)
{
        ut.begin();
        em.remove(em.merge(entity));
        ut.commit();
}