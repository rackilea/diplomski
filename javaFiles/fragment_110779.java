public static void main(String[] args) throws InstantiationException, IllegalAccessException{
        GroovyClassLoader loader = new DefaultImportClassLoader(new GroovyClassLoader());
        Class groovyClass = loader.parseClass(DefaultImportClassLoader.class.getClassLoader().getResourceAsStream("so_22729226/test.groovy"));
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        groovyObject.invokeMethod("run", null);
    }