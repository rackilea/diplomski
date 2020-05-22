public static Object[] unpack(Object array) {
    Object[] array2 = new Object[Array.getLength(array)];
    for(int i=0;i<array2.length;i++)
        array2[i] = Array.get(array, i);
    return array2;
}