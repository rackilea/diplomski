Releaser nopReleaser = new Releaser() {
    @Override
    public void release(Pointer<?> pointer) {
        // NOP
    }
};
hwnd = Pointer.pointerToAddress(hwndVal, Integer.class, nopReleaser);