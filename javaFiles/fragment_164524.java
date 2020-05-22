import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {

    @SuppressWarnings("unused")
    private static Integer[] targetArray = new Integer[] { 0, 1, 2, 3, 4, 5 };

    public static void main(String[] args) throws Exception {
        Field arrayMember = Main.class.getDeclaredField("targetArray");
        arrayMember.setAccessible(true);

        Object array = arrayMember.get(null);

        int length = Array.getLength(array);

        // get class of array element
        Class<? extends Object> elementType = array.getClass().getComponentType();
        Object copy = Array.newInstance(elementType, length);

        for (int i = 0; i < length; i++) {
            Array.set(copy, i, Array.get(array, i));
        }

        // if you know the type, you can cast
        if (Integer[].class.isInstance(copy)) {
            System.out.println("Integer[].class.isInstance(copy) == true");
            Integer[] copiedArray = Integer[].class.cast(copy);
            for (Integer i : copiedArray)
                System.out.println(i);
        } else {
            for (int i = 0; i < length; i++) {
                System.out.println(Array.get(copy, i));
            }
        }
    }
}