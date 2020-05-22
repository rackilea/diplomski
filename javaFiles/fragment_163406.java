private void readSerialData(Object obj, ObjectStreamClass desc)
    throws IOException
{
    ObjectStreamClass.ClassDataSlot[] slots = desc.getClassDataLayout();

    ...

    for (int i = 0; i < slots.length; i++) {
        ObjectStreamClass slotDesc = slots[i].desc;

        if (slots[i].hasData) {
            if (obj == null || handles.lookupException(passHandle) != null) {
                ...
            } else {
                FieldValues vals = defaultReadFields(obj, slotDesc);
                if (slotValues != null) {
                    slotValues[i] = vals;
                } else if (obj != null) {
                    defaultCheckFieldValues(obj, slotDesc, vals);
                    defaultSetFieldValues(obj, slotDesc, vals);
                }
            }
            ...
        }
    }
    ...
}

private class FieldValues {
    final byte[] primValues;
    final Object[] objValues;

    FieldValues(byte[] primValues, Object[] objValues) {
        this.primValues = primValues;
        this.objValues = objValues;
    }
}

/**
 * Reads in values of serializable fields declared by given class
 * descriptor. Expects that passHandle is set to obj's handle before this
 * method is called.
 */
private FieldValues defaultReadFields(Object obj, ObjectStreamClass desc)
    throws IOException
{
    Class<?> cl = desc.forClass();
    if (cl != null && obj != null && !cl.isInstance(obj)) {
        throw new ClassCastException();
    }

    byte[] primVals = null;
    int primDataSize = desc.getPrimDataSize();
    if (primDataSize > 0) {
        primVals = new byte[primDataSize];
        bin.readFully(primVals, 0, primDataSize, false);
    }

    Object[] objVals = null;
    int numObjFields = desc.getNumObjFields();
    if (numObjFields > 0) {
        int objHandle = passHandle;
        ObjectStreamField[] fields = desc.getFields(false);
        objVals = new Object[numObjFields];
        int numPrimFields = fields.length - objVals.length;
        for (int i = 0; i < objVals.length; i++) {
            ObjectStreamField f = fields[numPrimFields + i];
            objVals[i] = readObject0(f.isUnshared());
            if (f.getField() != null) {
                handles.markDependency(objHandle, passHandle);
            }
        }
        passHandle = objHandle;
    }

    return new FieldValues(primVals, objVals);
}

...