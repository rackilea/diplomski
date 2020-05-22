ClassLoader cl1 = new URLClassLoader(new URL[]{"singleton.jar"}, null);
ClassLoader cl2 = new URLClassLoader(new URL[]{"singleton.jar"}, null);
Class<?> singClass1 = cl1.loadClass("hacking.Singleton");
Class<?> singClass2 = cl2.loadClass("hacking.Singleton");
//...
Method getInstance1 = singClass1.getDeclaredMethod("getInstance", ...);
Method getInstance2 = singClass2.getDeclaredMethod("getInstance", ...);
//...
Object singleton1 = getInstance1.invoke(null);
Object singleton2 = getInstance2.invoke(null);