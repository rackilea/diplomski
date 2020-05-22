System.setProperty("java.library.path", "path/to/dll");

// forces the classloader to reload the cache the first time a native 
// library is being loaded
final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
sysPathsField.setAccessible(true);
sysPathsField.set(null, null);