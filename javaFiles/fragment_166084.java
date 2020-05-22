public class ChildService
{
    private EntityManager em;

    public List<Child> getChildren(long parentId)
    {
        Query query = em.createQuery("SELECT c FROM Parent p JOIN FETCH p.children AS c WHERE p.parentId = :parentId");
        query.setParameter("parentId", parentId);
        return (List<Child>) q.getResultList();
    }

    public Child getNamedChild(long parentId, String name)
    {
        Query query = em.createQuery("SELECT c FROM Parent p JOIN FETCH p.children AS c WHERE p.parentId = :parentId AND c.name = :name");
        query.setParameter("parentId", parentId);
        query.setParameter("name", name);
        return (Child) q.getSingleResult();
    }