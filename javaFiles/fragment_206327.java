public static void main(final String[] args) throws Exception{
    Class<?> clazz = Class.forName("hidden.YouCantInstantiateMe");
                                            // load class by name
    Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
    // getDeclaredConstructor(paramTypes) finds constructors with
    // all visibility levels, we supply no param types to get the default
    // constructor
    defaultConstructor.setAccessible(true); // set visibility to public
    defaultConstructor.newInstance();       // instantiate the class
}