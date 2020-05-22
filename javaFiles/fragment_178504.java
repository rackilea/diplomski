@PersistenceContext
 private EntityManager emf;

 @GetMapping("/load")
 public void load() {
    CriteriaBuilder cb = emf.getCriteriaBuilder();
    CriteriaQuery<Permissions> cq = cb.createQuery(Permissions.class);
    Root<Permissions> rPermission = cq.from(Permissions.class);
    cq.select(rPermission);
    cq.where(cb.equal(rPermission.get("nuserId"),730));    
    List<Permissions> results = em.createQuery(cq).getResultList();
    for (Permissions permission : results) {
        System.out.println("Number = " + permission.getSpermissionType());
    }
}