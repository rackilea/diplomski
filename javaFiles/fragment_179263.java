public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    for(Method m : int[].class.getDeclaredMethods())
        System.out.println(m);
    for(Method m : int[].class.getSuperclass().getDeclaredMethods())
        System.out.println(m);
    Method clone = int[].class.getSuperclass().getDeclaredMethod("clone");
    clone.setAccessible(true);
    int[] ints = { 1,2,3 };
    int[] ints2 = (int[]) clone.invoke(ints);
    System.out.println(Arrays.toString(ints2));
}