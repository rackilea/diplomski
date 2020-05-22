try {
    ...
} catch (Exception e) {
    if (e instanceof ServletException) {
        e = e.getCause();
    }
    if (e instanceof InvocationTargetException) {
        e = e.getCause();
    }
    if (e instanceof LoginException) {
        System.err.println("Login exception returned message: "
            + ((LoginException)e). getErrorMessage());
    } else {
        System.err.println("Exception returned message: " + e);
    }
}