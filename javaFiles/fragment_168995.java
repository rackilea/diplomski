protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
    ObjectStreamClass read = super.readClassDescriptor();
    if (read.getName().startsWith("com.old.package.")) {
        return ObjectStreamClass.lookup(Class.forName(read.getName().replace("com.old.package.", "org.new.package.")));
    }
    return read;
}