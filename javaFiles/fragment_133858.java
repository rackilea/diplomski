@Transactional
public void fooBar() {
   //Exception from this line
   Session session = getEntityManager().unwrap(Session.class);
   ...
}