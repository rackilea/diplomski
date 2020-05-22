DependencyInjector dependencyInjector = new DependencyInjector() {
    @Override
    public void inject(Job job) {
        if (job instanceof MyActualJob) {
            ((MyApplication) app).component().inject((MyActualJob) job);
        } else if (job instanceof MyRealJob) {
            ((MyApplication) app).component().inject((MyRealJob) job);
        } else if (job instanceof MyBetterJob) {
            ((MyApplication) app).component().inject((MyBetterJob) job);
        }
    }
};