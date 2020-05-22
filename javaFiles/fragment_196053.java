entityManager.getTransaction().begin();
UnitOfWorkImpl unitOfWork = (UnitOfWorkImpl)((JpaEntityManager)entityManager.getDelegate()).getActiveSession();
unitOfWork.beginEarlyTransaction();
java.sql.Connection connection = unitOfWork.getAccessor().getConnection();
...
entityManager.getTransaction().commit();