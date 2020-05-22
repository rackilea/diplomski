public class <T> RemoteVariable {
    private final RemoteDeviceProxy wrappedDevice;
    private final Class<T> clazz;

    public RemoteVariable(RemoteDeviceProxy wrappedDevice, Class<T> clazz) {
        this.wrappedDevice = wrappedDevice;
        this.clazz = clazz;
    }

    public T get() {
        if(clazz == Boolean.class){return clazz.cast(wrappedDevice.getBoolean());}
        else if(clazz == Integer.class){return clazz.cast(wrappedDevice.getInteger());}
        // ...
    }

    // ...
}