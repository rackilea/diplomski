public static void deleteYear(Years year)
{
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(year);
    session.getTransaction().commit();
    session.close();
}