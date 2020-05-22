if (task.call()) {
     URLClassLoader classLoader = new URLClassLoader(new URL[]{new File("./plugins/WebC/plugins/").toURI().toURL()});
     Class<?> loadedClass = classLoader.loadClass(className);
     Object obj = loadedClass.newInstance();
     if (obj instanceof CommandProcessor) {
         CommandProcessor cmd = (CommandProcessor)obj;
         classLoader.close();
         return cmd;
     }else{
        classLoader.close();
     }
 }