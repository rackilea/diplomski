final File tmpDir = new File(activity.getCacheDir().toString());

tmpDir.mkdirs();

DexClassLoader classLoader = new DexClassLoader(
        pathToJar, tmpDir.getAbsolutePath(), null, BotLoader.class.getClassLoader());
return classLoader.loadClass(className);