import java.lang.reflect.Constructor;

...

Class<?> loadedClass = classLoader.loadClass("tmp."+className);
try {
  Constructor<?> ctor=loadedClass.getConstructor(int.class);
  ctor.newInstance(42);
  ...
}
...