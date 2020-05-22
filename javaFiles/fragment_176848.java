try {
    final Animal a1 = new Animal();
    Throwable thr = null;
    try {
        foo();
    } catch (Throwable root) {
        thr = root;
        throw root;
    } finally {
        if (a1 != null) {
            if (thr != null) {
                try {
                    a1.close();
                } catch (Throwable suppressed) {
                    thr.addSuppressed(suppressed); // <<<<<< suppressing the failure of 'close'
                }
            } else {
                a1.close();
            }
        }
    }
} catch (Exception e) {
    System.err.println(e);
    for (Throwable t : e.getSuppressed()) {
        System.err.println("suppressed " + t);
    }
}