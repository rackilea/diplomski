public ContactListener() {
    this(false);
    if (!setEvents())
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Only one method per callback event can be overridden.");
    enable();
}

...

public void enable() {
    CollisionJNI.ContactListener_enable(swigCPtr, this);
}