context.addInstallerEventListener(new InstallerEventListener() {
    @Override
    public void installerEvent(InstallerEvent event) {
        if (event.getType() == EventType.CANCELLING) {
            // custom rollback
        }
    }
});