private Object internal_var;

// Implementation notice: do not remove this generic.
// Due to a Java limitation, we *do* want these two constraints!
public <T extends Serializable & Cloneable> void setVar(T val) {
    internal_var = val;
}

public Serializable getSerializable() {
    return (Serializable) internal_var; // Type checked in setter!
}

public Cloneable getCloneable() {
    return (Cloneable) internal_var; // Type checked in setter!
}

// This is the way to use it in a generic getter:
public <T extends Serializable & Cloneable> T getVar(Class<? super T> cls) {
    return (T) cls.cast(val);
}