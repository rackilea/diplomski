@Override
public void deleteWalletInfoById(Long id) {

    try (Session session = getSessionFactory().openSession()) {

        Query query = session.createQuery("delete WalletInfo where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();

        System.out.println("Result = " + result);

    } catch (HibernateException e) {

        System.out.println("No result");
        e.printStackTrace();
    }
}