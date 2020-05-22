EntityTransaction entityTransaction;
        EntityManager entityManager;

        try
        {
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            // rowsUpdated - The number of "affected rows".
            int rowsUpdated = entityManager.createNativeQuery("create table test (id nubmer)").executeUpdate();

            entityTransaction.commit();
        }
        catch (HibernateException | IllegalStateException e)
        {
            // handle exceptions

            if (entityTransaction != null && entityTransaction.isActive())
            {
                entityTransaction.rollback();
            }
        }