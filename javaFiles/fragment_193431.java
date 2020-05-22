private void doExecRequest(Runnable callback) {
    //some code       
    SampleReturn sample = cache.get("exec key");
    if (sample != null && sample.valid()) {
        callback.run();
    }
}