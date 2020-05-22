@Override
protected java.io.ObjectStreamClass readClassDescriptor() 
        throws IOException, ClassNotFoundException {
    ObjectStreamClass desc = super.readClassDescriptor();
    if (desc.getName().equals("oldpkg.Widget")) {
        return ObjectStreamClass.lookup(newpkg.Widget.class);
    }
    return desc;
};