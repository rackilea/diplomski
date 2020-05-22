private Session mSession;
Config config = new Config(mSession);

if (!mSession.isSupported(config)) {
    showSnackbarMessage("This phone doesn't support AR", true);
}
mSession.configure(config);