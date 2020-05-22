public String create() {
    try {
        utx.begin();
    } catch (Exception ex) {
    }
    try {
        Exception transactionException = null;
        comment.setUserId(userController.getUser());
        comment.setMovieId(movieController.getMovie());
        jpaController.create(comment); ...Default Facade class
        try {
            utx.commit();
        } catch (javax.transaction.RollbackException ex) {
            transactionException = ex;
        } catch (Exception ex) {
        }...
          ...