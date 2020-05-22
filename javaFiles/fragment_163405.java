private void readSerialData(Object obj, ObjectStreamClass desc)
    throws IOException
{
    ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();
    for (int i = 0; i < slots.length; i++) {
        ObjectStreamClass slotDesc = slots[i].desc;

        if (slots[i].hasData) {
            if (obj == null || handles.lookupException(passHandle) != null) {
                ...
            } else {
                defaultReadFields(obj, slotDesc);
            }
            ...
        }
    }
}

/**
 * Reads in values of serializable fields declared by given class
 * descriptor.  If obj is non-null, sets field values in obj.  Expects that
 * passHandle is set to obj's handle before this method is called.
 */
private void defaultReadFields(Object obj, ObjectStreamClass desc)
    throws IOException
{
    Class<?> cl = desc.forClass();
    if (cl != null && obj != null && !cl.isInstance(obj)) {
        throw new ClassCastException();
    }

    int primDataSize = desc.getPrimDataSize();
    if (primVals == null || primVals.length < primDataSize) {
        primVals = new byte[primDataSize];
    }
    bin.readFully(primVals, 0, primDataSize, false);
    if (obj != null) {
        desc.setPrimFieldValues(obj, primVals);
    }

    int objHandle = passHandle;
    ObjectStreamField[] fields = desc.getFields(false);
    Object[] objVals = new Object[desc.getNumObjFields()];
    int numPrimFields = fields.length - objVals.length;
    for (int i = 0; i < objVals.length; i++) {
        ObjectStreamField f = fields[numPrimFields + i];
        objVals[i] = readObject0(f.isUnshared());
        if (f.getField() != null) {
            handles.markDependency(objHandle, passHandle);
        }
    }
    if (obj != null) {
        desc.setObjFieldValues(obj, objVals);
    }
    passHandle = objHandle;
}
...