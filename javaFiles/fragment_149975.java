public void runInSession(Runnable<IDfSession> runnable) {

    IDfSession session = null;
    try {

        session = manager.getSession(DfsUtils.getCurrentRepository());
        runnable.run(session);        

    } finally {
        if (session != null) {
            manager.release(session);
        }
    }

}