ClassPool cp = ClassPool.getDefault();
cp.insertClassPath(new ClassClassPath(this.getClass()));
ClassPath cp1 = null;
ClassPath cp2 = null;

// add the JAR file to the classpath
try {
    cp1 = cp.insertClassPath(jarFile.getAbsolutePath());
} catch (NotFoundException e1) {
    e1.printStackTrace();
    return null;
}
// add the class file we are going to modify to the classpath
cp2 = cp.appendClassPath(new ByteArrayClassPath(className, classBytes));

byte[] modifiedBytes;
try {
    CtClass cc = cp.get(className);
    // skip instrumentation if the class is frozen and therefore
    // can't be modified
    if (!cc.isFrozen()) {
        // do your javassist stuff here
    }
    modifiedBytes = cc.toBytecode();
} catch (NotFoundException | IOException | CannotCompileException | ClassNotFoundException e) {
    handleException(e);
} finally {
    // free the locked resource files
    cp.removeClassPath(cp1);
    cp.removeClassPath(cp2);
}

// write your modified bytes somewhere
if (modifiedBytes.length > 0) {
    try(FileOutputStream fos = new FileOutputStream("pathname")) {
        fos.write(modifiedBytes);
    }
}