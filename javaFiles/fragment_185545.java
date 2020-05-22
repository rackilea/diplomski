Policy allPermissionPolicy = new Policy() {

    @Override
    public boolean implies(ProtectionDomain domain, Permission permission) {
        return true;
    }
};