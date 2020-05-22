public enum FloatEnum {
    STUFF({ float array of STUFF }),
    STUFF2({ float array of STUFF2 });

    private final float[] data;

     private FloatEnum(float[] data) {
        this.data = data;
    }

    public float[] getData() {
         return this.data;
    }

    public static float[] getDataFor(String str) {
         FloatEnum e = valueOf(str);
         return e.getData();
    }
}