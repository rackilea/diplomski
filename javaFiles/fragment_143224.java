public enum ScreenOrientation {

    LANDSCAPE_FIXED("LANDSCAPE_FIXED", 0);
    // other values

    private final String s;
    private final int i;

    private ScreenOrientation(String s, int i) {
        this.s = s;
        this.i = i;
    }

    // getters for s and i

    @Override
    public String toString() { 
        return this.getS();
    }

    public static ScreenOrientation fromS(String s) {
        for( ScreenOrientation so : values())
            if(so.getS().equalsIgnoreCase(s)) {
                return so;
        }
       throw new IllegalArgumentException();
    }
}