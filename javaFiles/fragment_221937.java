/*...object creation... */
final SessionFactory sf = context.getBean("sessionFactory");
/* Session creation */
final Session s = sf.openSession();
ChildDAO childDAO = (ChildDAO) context.getBean("childDAO");

childDAO.persistChild(child);
/*other code*/
/* session close */
s.close();