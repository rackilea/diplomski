public class Test {

    public static <T> boolean isPrimitiveWrapper(T p_obj) throws Exception {
        return isPrimitiveWrapper(p_obj.getClass());
    }

    public static boolean isPrimitiveWrapper(Class p_obj) throws Exception {
        if (Number.class.isAssignableFrom(p_obj)) {
            return true;
        } else if (Boolean.class.isAssignableFrom(p_obj)) {
            return true;
        } else if (Character.class.isAssignableFrom(p_obj)) {
            return true;
        } else if (p_obj.isArray()) {

            //To handle multi dimension array
            while (p_obj.isArray()) {
                p_obj = p_obj.getComponentType();
            }

            return isPrimitiveWrapper(p_obj);
        }

        return false;
    }

    public static boolean isPrimitiveWrapper(boolean p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(byte p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(short p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(float p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(int p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(long p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(char p_obj) {
        return false;
    }

    public static boolean isPrimitiveWrapper(double p_obj) {
        return false;
    }

    public static void main(String[] args) throws Exception {
        Integer[][][] a = {{{0}}, {{1}}, {{0}}};
        int[][][] b = {{{0}}, {{1}}, {{0}}};

        println(isPrimitiveWrapper(a));
        println(isPrimitiveWrapper(a[0]));
        println(isPrimitiveWrapper(a[0][0]));
        println(isPrimitiveWrapper(a[0][0][0]));

        println(isPrimitiveWrapper(b));
        println(isPrimitiveWrapper(b[0]));
        println(isPrimitiveWrapper(b[0][0]));
        println(isPrimitiveWrapper(b[0][0][0]));
    }

    public static <T> void println(T p_t) {
        System.out.println(p_t);
    }

}