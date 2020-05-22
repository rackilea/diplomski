File janinoSourceDir = new File(PATH_TO_JAVAFILE);
    File[] srcDir = new File[] { janinoSourceDir };
    String encoding = null;
    ClassLoader parentClassLoader = this.getClass().getClassLoader();
    ClassLoader cl = new JavaSourceClassLoader(parentClassLoader, srcDir,
            encoding);