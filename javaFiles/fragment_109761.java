try {
  /** define the session and begin it **/
  hbsession = HibernateUtil.getSessionFactory().getCurrentSession();
  hbsession.beginTransaction();

  /** table is the name of the Bean class linked to the corresponding SQL table **/
  String query = "UPDATE table SET name = " + textfield.getValue();

  /** Run the string as an SQL query **/
  Query q = hbsession.createQuery(query);
  q.executeUpdate(); /** This command saves changes or deletes a entry in table **/

  hbsession.getTransaction().commit();
} catch (RuntimeException rex) {
    hbsession.getTransaction().rollback();
    throw rex;
}