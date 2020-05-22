public static void main(String[] args)
{
    test(int[].class);
}

static void test(Class clazz)
{
    System.out.println(clazz.getName());
    System.out.println(clazz.getSuperclass());
    for(Class face : clazz.getInterfaces())
        System.out.println(face);
}