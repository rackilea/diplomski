public static <E> void save(Class<E> classType)
{
    try {
        E object = classType.newInstance();
        System.out.println(object.getClass());
    }
    catch (Exception e) {
    }
}