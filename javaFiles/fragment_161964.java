public static Object createClass(String className, Double value){
    Class a = Class.forName(className);
    Class[] params = new Class[]{Integer.class};
    Constructor c = a.getConstructor(params);
    Object[] values = new Object[]{value};
    return c.newInstance();
}