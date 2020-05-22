System.setSecurityManager(new SecurityManager() {
    @Override
    public void checkExit(int status) {
        new Exception("exit attempt with return code "+status).printStackTrace();
    }
    // note that all dedicated check... methods delegate to the two below,
    // so overriding these is sufficient to enable all other actions
    @Override
    public void checkPermission(Permission perm, Object context) { }

    @Override
    public void checkPermission(Permission perm) { }
});