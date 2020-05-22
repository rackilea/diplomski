public Robot loadByClassName(String classname) {
    Class<?> loadClass;
    try {
        loadClass = Class.forName(classname);
        return (Robot) loadClass.getConstructor().newInstance();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;

}