/**
 * Returns serializable fields of given class as defined explicitly by a
 * "serialPersistentFields" field, or null if no appropriate
 * "serialPersistentFields" field is defined.  Serializable fields backed
 * by an actual field of the class are represented by ObjectStreamFields
 * with corresponding non-null Field objects.  For compatibility with past
 * releases, a "serialPersistentFields" field with a null value is
 * considered equivalent to not declaring "serialPersistentFields".  Throws
 * InvalidClassException if the declared serializable fields are
 * invalid--e.g., if multiple fields share the same name.
 */
private static ObjectStreamField[] getDeclaredSerialFields(Class<?> cl)
    throws InvalidClassException
{
    ObjectStreamField[] serialPersistentFields = null;
    try {
        Field f = cl.getDeclaredField("serialPersistentFields");
        int mask = Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL;
        if ((f.getModifiers() & mask) == mask) {
            f.setAccessible(true);
            serialPersistentFields = (ObjectStreamField[]) f.get(null);
        }
    } catch (Exception ex) {
    }