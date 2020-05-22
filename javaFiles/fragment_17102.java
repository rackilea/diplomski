URL dirUrl = new URL("file:/" + "path_to_dir" + "/");             // 1
URLClassLoader cl = new URLClassLoader(new URL[] {dirUrl},
                             getClass().class.getClassLoader());  // 2
Class loadedClass = cl.loadClass("com.xyz.MyClass");
MyClass obj = (MyClass) loadedClass.newInstance();
obj.doSomething();