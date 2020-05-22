for (int i = 1; i < 9; i++) {
    if (methods[i].isAnnotationPresent(Test.class) && 
           (methods[i].getAnnotation(Test.class).value() < i)) {
        methods[i].invoke(c.newInstance());
    }
}