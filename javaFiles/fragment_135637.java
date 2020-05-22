byte[] dex = ...

    /*
     * This implementation currently dumps the dex to the filesystem. It
     * jars the emitted .dex for the benefit of Gingerbread and earlier
     * devices, which can't load .dex files directly.
     *
     * TODO: load the dex from memory where supported.
     */
    File result = File.createTempFile("Generated", ".jar", dexCache);
    result.deleteOnExit();
    JarOutputStream jarOut = new JarOutputStream(new FileOutputStream(result));
    jarOut.putNextEntry(new JarEntry(DexFormat.DEX_IN_JAR_NAME));
    jarOut.write(dex);
    jarOut.closeEntry();
    jarOut.close();
    try {
        return (ClassLoader) Class.forName("dalvik.system.DexClassLoader")
                .getConstructor(String.class, String.class, String.class, ClassLoader.class)
                .newInstance(result.getPath(), dexCache.getAbsolutePath(), null, parent);
    } catch (ClassNotFoundException e) {
        throw new UnsupportedOperationException("load() requires a Dalvik VM", e);
    } catch (InvocationTargetException e) {
        throw new RuntimeException(e.getCause());
    } catch (InstantiationException e) {
        throw new AssertionError();
    } catch (NoSuchMethodException e) {
        throw new AssertionError();
    } catch (IllegalAccessException e) {
        throw new AssertionError();
    }