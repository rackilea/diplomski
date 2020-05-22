class MyClassLoader extends ClassLoader {
     public Class findClass(String name) {
         byte[] b = loadClassData(name);
         return defineClass(name, b, 0, b.length);
     }

     private byte[] loadClassData(String name) {
         JarInputStream jis = new JarInputStream(new ByteArrayInputStream(bytearrayJarData));
         JarEntry entry = jis.getNextJarEntry();
         while (entry != null) {
                //compare entry to requested class
                // if match, return Byte data
                // else entry = jis.getNextJarEntry();
         }
         return null; // nothing found
     }
 }