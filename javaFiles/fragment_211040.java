public abstract class AbstractRepository<T> implements IRepository<T> {
  @Override
  public T add(T object) {
    Session session = openSession();
    try {
      session.getTransaction().begin();
      session.save( object );
      session.getTransaction().commit();
      return object;
    }
    catch ( Exception e ) {
      if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE ) {
        session.getTransaction().rollback();
      }
      throw e;
    }
    finally {
      session.close();
    }
  }
}