static interface Hatchery {
    public <X extends CharSequence, Y extends ConfiguredProduct<X>> Worker<Y> breed();
}

static class WorkerHatchery implements Hatchery{
    public   Worker<ConfiguredProduct<String>> breed(){
        return new StringWorker();
    }
}