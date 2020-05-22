public void doSomeWork() {
    Session sess = factory.openSession();
    try {
        //set transaction timeout to 3 seconds
        sess.getTransaction().setTimeout(3);
        sess.getTransaction().begin();

        // do some work

        sess.getTransaction().commit()
    }
    catch (RuntimeException e) {
        sess.getTransaction().rollback();
        throw e; // or display error message
    }
    finally {
        sess.close();
    }
}