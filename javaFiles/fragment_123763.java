public void meth1() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        utx.begin();
        Log newLog = em.merge(log);
        newLog.setMessage(String.valueOf(Math.random()));//we make the changes to the managed instance
        utx.commit();
    }