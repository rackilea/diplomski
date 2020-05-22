public class Test {

    public static void main(String[] args) {
        Integer[][] array = readArray(Integer[][].class, 10);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + ",");
            System.out.println();
        }
    }

    // T = Integer[][]
    // S = Integer[]
    public static <T, S> S[] readArray(final Class<T> cls, final int length) {
        if (cls.isArray()) {
            final Class<S> subCls = (Class<S>) cls.getComponentType();
            final S[] array = (S[]) Array.newInstance(subCls, length);
            for (int i = 0; i < length; i++) {
                if (subCls.isArray()) {
                    array[i] = (S) readArray((Class<?>) subCls, length);
                } else {
                    array[i] = (S) next();
                }
            }
            return array;
        }
        throw new IllegalArgumentException("Type of cls must be an array.");
    }

    private static Object next() {
        // TODO Auto-generated method stub
        return 1;
    }
}