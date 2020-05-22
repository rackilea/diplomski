psHandler.addNewUser(name, LoginActivity.this, new RetrievedCallback<Void>() {
    @Override
    public void execute(Void input) {
        try {
            throw new IllegalStateException();
        } catch (IllegalStateException e) {
            // This line will be reached
        }
    }
});