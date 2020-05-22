if (t instanceof ParameterizedType) {
    Type[] args = ((ParameterizedType) t).getActualTypeArguments();
    for (Type arg : args) {
        // This will print e.g. 'class com.example.Employee'
        System.out.println(arg);
    }
}