private static class CameraSize {
    public CameraSize(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Keep
    public int h;
    @Keep
    public int w;
}