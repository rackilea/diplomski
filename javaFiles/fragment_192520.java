for (int priority = 8; priority> 0; priority--){
    for(Method method : methods){
        if (method.isAnnotationPresent(Test.class) && 
            method.getAnnotation(Test.class).value() == i){
            method.invoke(c.newInstance());
            break; // continue outer loop
        }
    }
}