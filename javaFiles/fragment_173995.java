public static class WindowProcUnion extends Union {
    public Pointer ptr;
    public WinUser.WindowProc wndProc;

    public WindowProcUnion(Pointer ptr) {
        this.ptr = ptr;
        setType("ptr");
        write();
        setType("wndProc");
        read();
    }
}