final Login l=(Login) Naming.lookup("rmi://xxxx/yyyy");

// Passed in to run asynchronously based on internal method behavior
l.validate(uname,pass, new Login.OnLoginListener() {
    @Override
    public void onSuccess(String username) {
        l.login();
        HomePage h=new HomePage();
        h.setvisible(true);
    }

    @Override
    public void onError(String message) {
        System.err.println(message);
    }

});