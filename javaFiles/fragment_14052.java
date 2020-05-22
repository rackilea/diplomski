@Override
    public boolean close() {
        // make sure clientSite is disposed first
        if (clientSite != null && !clientSite.isDisposed()) {
            clientSite.dispose();
        }
        return super.close();
    }