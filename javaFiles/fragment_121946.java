Task.Builder b = new Task.Builder():
b.knownProperty(value).anotherProperty(value2);

myExecutor.schedule(b);


...
void schedule(Task.Builder b) {
    b.propertyBeforeExecute(value);
    Task t = b.build();
}