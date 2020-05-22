WaitingFuture<ModelObject> future = new WaitingFuture<ModelObject>(service.doSomething());
ModelObject result = future.get(3000); //Instead of throwing a timeout, this impl could just return null if 3 seconds pass with no answer
if(result == null) {
    //Path A
} else {
    //Path B
}