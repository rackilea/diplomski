//get all methods defined in ClassA
    Method[] methods = ClassA.class.getMethods();
    for (Method m : methods) {
        //pick only the ones annotated with "@RequestMapping"
        if (m.isAnnotationPresent(RequestMapping.class)) {
            RequestMapping ta = m.getAnnotation(RequestMapping.class);
            System.out.println(ta.value()[0].toString());
        }
    }