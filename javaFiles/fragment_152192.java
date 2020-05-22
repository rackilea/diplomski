Session session = HibernateUtil.getSession();
try {
    String hql = "FROM TreeNode tn JOIN tn.nodeAsset WHERE tn.id=5";
    Query query = session.createQuery(hql);
    List result = query.list();
    System.out.println("done");
} catch (HibernateException e) {
    e.printStackTrace();
    throw new Exception("Query failed", e);
} finally {
    session.flush();
    session.close();
}