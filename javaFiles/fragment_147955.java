public Task<Boolean> doLogin() {
    return new Task<Boolean>() {
        @Override
        protected Boolean call() {
            Boolean result = null;
            user.login();
            if (!user.getIsAuthorized()) {
                result = Boolean.FALSE;
            } else {
                result = Boolean.TRUE;
            }
            user.remember();
            return result;
        }
    };
}