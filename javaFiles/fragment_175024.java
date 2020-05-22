Set<Class<?>> msgDrivenClasses = findAllMessageDrivenClasses();
for (Object o : objects) {
  if (msgDrivenClasses.contains(o.getClass()) {
    invokeTheMessageListener(o);
  }
}