public void getAllClassAndFields() {
    ObjectFactory objectFactory = new ObjectFactory();
    Method[] methods = objectFactory.getClass().getDeclaredMethods();
    for (Method method : methods) {
        try {
            // Check if method have XmlElementDecl annotation
            XmlElementDecl annotation = method.getAnnotation(XmlElementDecl.java);
            if (annotation == null) {
                // Invoke method only if it is not annoatated with XmlElementDecl 
                Object object = method.invoke(objectFactory, new Object[] {});
                System.out.println("Class Name = " + object.getClass().getName());
                printFileds(object);
            }

        } catch (Exception e) {
          // I used Exception to keep it simple, instead use appropriate exception types here 
        } 
    }
}

public static void printFileds(Object obj) {
    Field[] fields = obj.getClass().getFields();
    for (Field field : fields) {
        System.out.println("Field Name = " + field.getName());
    }
}