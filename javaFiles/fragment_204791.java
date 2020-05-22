public boolean authenticate(Sting username,String pass){
Session ses = NewHibernateUtil.getSessionFactory().openSession();            
String sql = "from Login login where login.username:= username and login.pass = :=pass";
Query query = session.createQuery(sql);
query.setString("username",username);
query.setString("pass",pass);
List<Login> result = query.list();
 //close session, transaction,etc....
if (result ==null)
  return false;
else
  return true;
}