try {
    psHandler.addNewUser(name, LoginActivity.this, new RetrievedCallback<Void>() {
        @Override
        public void execute(Void input) {
            throw new IllegalStateException();
        }
    });
} catch (IllegalStateException e) {
    // This line will never be reached because the exception 
    // is not thrown here, but inside the callback method
}