try {

    utx.begin();

    Query q3 = em.createQuery("DELETE FROM ItemModuleConnection");
    Query q4 = em.createQuery("DELETE FROM ModuleConnection");
    Query q1 = em.createQuery("DELETE FROM BomModule");
    Query q2 = em.createQuery("DELETE FROM BomItem");

    q1.executeUpdate();
    q2.executeUpdate();
    q3.executeUpdate();
    q4.executeUpdate();

    utx.commit();
} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
    e.printStackTrace();
}