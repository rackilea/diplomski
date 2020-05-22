@Override
public MyEntity find(Object id) {
    EntityManager em = getEntityManager();
    MyEntity ps = em.find(MyEntity .class, id);
    em.refresh(ps);
    return ps;
}