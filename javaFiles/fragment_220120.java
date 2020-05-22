public MyObject lock (MyObject controlnumbers) {
    String qStr = "select object(o) from MyObject as o where o.pk = :pk";
    Query q = em.createQuery(qStr);
    q.setParameter("pk", "a");
    q.setHint("toplink.pessimistic-lock", "Lock");
    controlnumbers = (MyObject)q.getSingleResult();
    return controlnumbers;
}