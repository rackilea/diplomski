public Object execute(Command command) throws BusinessException {

        EntityManager em = Jpa.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();

        Object ret = null;
        try {
            ret = command.execute(); // <-- This line throws RuntimeException
            trx.commit();
        } catch (BusinessException bex) {
            if(trx.isActive())
                trx.rollback();
            throw bex;
        } catch (RuntimeException tex) {
            if(trx.isActive())
                trx.rollback();
            trx.rollback(); <--- **The problem was here.**
            throw  tex;
        } finally {
            if(em.isOpen())
                em.close();
        }



        return ret;
    }