public interface Stack {
   [...]
}
[...]
    URLClassLoader urlcl = URLClassLoader.newInstance(new URL[] {
       new URL(
           "file:///I:/Studia/PW/Sem6/_repozytorium/workspace/Test/testJavaLoader.jar"
       )
    });
    Class<?> clazz = urlcl.loadClass("michal.collection.StackImpl");
    Class<? extends Stack> stackClass = clazz.asSubclass(Stack.class);
    Constructor<? extends Stack> ctor = stackClass.getConstructor();
    Stack stack = ctor.newInstance();