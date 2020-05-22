private class SingleInstance implements SingleInstanceListener {
    @Override
    public void newActivation(final String[] params) {
        logger.info("newActivation params=" + params);

        ... activation code here ...

    }
}