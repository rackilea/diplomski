public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Reflections reflections = new Reflections("java.util");
    Set<Class<? extends List>> classes = reflections.getSubTypesOf(java.util.List.class);
    for (Class<? extends List> aClass : classes) {
        System.out.println(aClass.getName());
        if(aClass == ArrayList.class) {
            List list = aClass.newInstance();
            list.add("test");
            System.out.println(list.getClass().getName() + ": " + list.size());
        }
    }
}