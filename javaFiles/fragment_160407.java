try {
    mConfig = new TangoConfig();
    mConfig = mTango.getConfig(TangoConfig.CONFIG_TYPE_CURRENT);
    mConfig.putBoolean(TangoConfig.KEY_BOOLEAN_DEPTH, true);
} catch (TangoErrorException e) {
    // handle exception
}