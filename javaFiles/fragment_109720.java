Configuration config = new Configuration() {
    @Override
    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        return new AppConfigurationEntry[]{
                new AppConfigurationEntry(NTLoginModule.class.getName(),
                    AppConfigurationEntry.LoginModuleControlFlag.REQUIRED,
                    new HashMap<>())
        };
    }
};
Configuration.setConfiguration(config);