/** The proportional set size for dalvik. */
    public int dalvikPss;
    /** The private dirty pages used by dalvik. */
    public int dalvikPrivateDirty;
    /** The shared dirty pages used by dalvik. */
    public int dalvikSharedDirty;

    /** The proportional set size for the native heap. */
    public int nativePss;
    /** The private dirty pages used by the native heap. */
    public int nativePrivateDirty;
    /** The shared dirty pages used by the native heap. */
    public int nativeSharedDirty;

    /** The proportional set size for everything else. */
    public int otherPss;
    /** The private dirty pages used by everything else. */
    public int otherPrivateDirty;
    /** The shared dirty pages used by everything else. */
    public int otherSharedDirty;