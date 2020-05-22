DependencyInjector dependencyInjector = new DependencyInjector() {
    @Override
    public void inject(Job job) {
        // this line depends on how your Dagger components are setup;
        // the important part is to cast job to BaseJob
        ((MyApplication) app).component().inject((BaseJob) job);
    }
};
Configuration configuration = new Configuration.Builder(getApplicationContext())
        .injector(dependencyInjector)
        .build();
JobManager jobManager = new JobManager(getApplicationContext(), configuration);