import java.lang.reflect.Array;

static long maskFor(Class<?> c) {
    return (
        c.equals(int.class) ? 1L << Integer.SIZE :
        c.equals(short.class) ? 1L << Short.SIZE :
        c.equals(byte.class) ? 1L << Byte.SIZE :
        0
    ) - 1;
}   
public static void reflectPrimitiveNumericArray(Object arr) throws Exception {
    int length = Array.getLength(arr);
    Class<?> componentType = arr.getClass().getComponentType();
    long mask = maskFor(componentType);
    System.out.format("%s[%d] = { ", componentType, length);
    for (int i = 0; i < length; i++) {
        long el = Array.getLong(arr, i) & mask;
        System.out.print(Long.toBinaryString(el) + " ");
    }
    System.out.println("}");
}