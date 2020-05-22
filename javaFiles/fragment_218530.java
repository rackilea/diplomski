URLClassLoader classLoader = new URLClassLoader(list.toArray(new URL[0]));
    Class<?> clazz = classLoader.loadClass(path);
    File tmp = new File(System.getProperty("java.io.tmpdir"), path.replace(".", "_") + ".class");
    FileChannel tmpChannel = new FileOutputStream(tmp).getChannel();
    InputStream is = clazz.getResourceAsStream("/" + path.replace(".", "/") + ".class");
    tmpChannel.transferFrom(Channels.newChannel(is), 0, Long.MAX_VALUE);
    URI uri = tmp.toURI();