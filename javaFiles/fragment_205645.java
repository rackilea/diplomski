import java.lang.reflect.Array;

public class Test {

        public static void main(String args[]) throws Exception {
                Object array[] = new Object[5];

                array = resizeArray(array, 10);

                for (Object o : array) {
                        System.out.println(o);
                }
        }

        public static <T>
        T[] resizeArray(T[] a, int newSize) throws Exception {
                T[] b = (T[]) Array.newInstance(a.getClass().getComponentType(),
                                                newSize);

                for (int i = 0; i < a.length; i++) {
                        b[i] = a[i];
                }

                return b;
        }
}