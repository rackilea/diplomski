public enum Axis {
    HORIZONTAL(true), VERTICAL(false);

    private boolean isHorizontal;

    Axis(boolean horizontal) {
        isHorizontal=horizontal;
    }
    public Axis getOther() {
        return isHorizontal? VERTICAL: HORIZONTAL;
    }
    public static void main(String... arg) {
        for(Method m: Axis.class.getDeclaredMethods())
            System.out.println(m);
        System.out.println("constructor:");
        System.out.println(Axis.class.getDeclaredConstructors()[0]);
    }
}