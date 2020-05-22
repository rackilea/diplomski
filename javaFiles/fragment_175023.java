Set<Class<?>> findAllMessageDrivenClasses() {
  final StopWatch sw = new StopWatch();
  sw.start();
  final Reflections reflections = new Reflections("org.projectx", new TypeAnnotationsScanner());
  Set<Class<?>> allMessageDrivens = reflections.getTypesAnnotatedWith(MyMessageDriven.class); // NOTE HERE
  sw.stop();
  return allMessageDrivens;
}