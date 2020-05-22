public static void main(final String[] args) throws Exception{
    final Collection<Class<?>> classes =
        getClassesUsedBy(Collections.class.getName(), "java.util");
    System.out.println("Used classes:");
    for(final Class<?> cls : classes){
        System.out.println(" - " + cls.getName());
    }

}