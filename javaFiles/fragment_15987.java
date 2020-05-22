private void bindFileLoaders() {
  MapBinder<String, FileLoader> mapBinder
      = MapBinder.newMapBinder(binder(), String.class, FileLoader.class);
  for (Class<? extends FileLoader> implClass : getFileLoaderClasses()) {
    FileLoaderType annotation = implClass.getAnnotation(FileLoaderType.class);
    if (annotation == null) {
      addError("Missing FileLoaderType annotation on " + implClass.getClass());
      continue;
    }
    mapBinder.addBinding(annotation.getValue()).to(implClass);
  }
}