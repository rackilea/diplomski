public class ParentDAO {
    @PersistenceContext
    private EntityManager em;

    public Parent findParentByName(name) {
      TypedQuery<Parent> q = em.createQuery("select p from Parent where p.name = :name", Parent.class);
      return q.setParameter("name", name).getSingleResult();
    }

    public void moveAllChildren(String srcName, String dstName) {
      Parent src = findParentByName(srcName);
      Parent dst = findParentByName(dstName);
      Set<Child> children = new HashSet<Child>();
      for (Child c: src.getChildren()) {
        children.add(c);
      }
      src.getChildren().removeAll(children);
      dst.getChildren().addAll(children);
    }
}