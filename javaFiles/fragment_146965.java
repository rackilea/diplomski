Class clsReaderClss = ClassLoader.getSystemClassLoader().loadClass("jdk.internal.org.objectweb.asm.ClassReader");
System.out.println("clsReaderClss = " + clsReaderClss);
Constructor con = clsReaderClss.getConstructor(InputStream.class);
Object reader = con.newInstance(new FileInputStream(directFile));
Method m = clsReaderClss.getMethod("getClassName");
String name = m.invoke(reader).toString().replace('/', '.');
System.out.println("name = " + name);