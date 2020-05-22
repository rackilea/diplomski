public Set<String> findClassNames(byte[] bytecode) {
    Set<String> classNames = new HashSet<String>();

    ClassReader classReader = new ClassReader(bytecode);
    ClassWriter classWriter = new ClassWriter(classReader, 0);

    ClassNameRecordingRemapper remapper = new ClassNameRecordingRemapper(classNames);
    classReader.accept(remapper, 0);

    return classNames;
}