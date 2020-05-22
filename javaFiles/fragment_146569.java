public interface Session {
  public abstract org.hibernate.Transaction getTransaction();
}

public Transaction {
  public abstract boolean wasRolledBack() throws org.hibernate.HibernateException;

  public abstract boolean wasCommitted() throws org.hibernate.HibernateException;

  public abstract boolean isActive() throws org.hibernate.HibernateException;
}