public void modifiedTestPlugins(){

    Object plugin = loadJar("C:\\Users\\...\\Desktop\\processor.jar",
            "C:\\Users\\...\\Desktop\\plugin.jar",
            "test.process.Process");

    try {
        Method processData = findMethod(obj.getClass(), "processData");

        //here I invoke the processData method, it prints: PROCESS DATAAAAAAAAAAAA
        loadData.invoke(processData, new Object[]{});
    } catch (Exception e) {
        e.printStackTrace();
    }

}

private static Method findMethod(Class clazz, String methodName) throws Exception {
    Method[] methods = clazz.getMethods();
    for (int i = 0; i < methods.length; i++) {
        if (methods[i].getName().equals(methodName))
            return methods[i];
    }
    return null;
}