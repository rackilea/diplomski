Future<ModelObject> future = doSomething();
try {
    ModelObject result = future.get(3000,TimeUnit.MILLISECONDS);
    //Path B
} catch (TimeoutException ex) {
    //Path A
}