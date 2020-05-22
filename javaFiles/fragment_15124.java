private final MybatisBundle<TestDropWizardConfiguration> mybatisBundle = new MybatisBundle<TestDropWizardConfiguration>("**com.example.helloworld**") {
    @Override
    public DataSourceFactory getDataSourceFactory(TestDropWizardConfiguration configuration) {
        return configuration.getDataSourceFactory();
    }
};