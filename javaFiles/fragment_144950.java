public Token authenticate(final String email, final String password) {
    final Token[] tokens = new Token[1];
    Thread mThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                tokens[0] = adapter.authenticate(email, password);
            } catch (NotAuthenticatedException e) {

            }
        }
    });
    mThread.start();
    mThread.join();
    return tokens[0];
}