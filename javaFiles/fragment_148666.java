GroovyClassLoader loader = new GroovyClassLoader();
Reader reader = new BufferedReader(clob.getCharacterStream());
GroovyCodeSource source = new GroovyCodeSource(reader, name, "xb3.Classifier");
Class<?> groovyClass = loader.parseClass(source);
Object possibleClass = groovyClass.newInstance();
if (expectedType.isAssignableFrom(possibleClass.getClass())) {
    classifiers.put((T) possibleClass, name);
}
reader.close();
// Tell Groovy we don't need any meta
// information about these classes
GroovySystem.getMetaClassRegistry().removeMetaClass(possibleClass.getClass());
// Tell the loader to clear out it's cache,
// this ensures the classes will be GC'd
loader.clearCache();