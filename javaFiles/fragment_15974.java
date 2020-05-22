for (Annotation annotation : Test.class.getAnnotations()) {
    System.out.println(toString(annotation));
}

private String toString(Annotation annotation) throws InvocationTargetException, IllegalAccessException {
    Map<String, Object> paramValues = getParamValues(annotation);
    StringBuilder result = new StringBuilder("@")
            .append(annotation.annotationType().getSimpleName())
            .append("(");
    for (Map.Entry<String, Object> param : paramValues.entrySet()) {
        result.append(param.getKey()).append("=\"").append(param.getValue()).append("\", ");
    }
    result.delete(result.length() - 2, result.length());
    return result.append(")").toString();
}

private Map<String, Object> getParamValues(Annotation annotation) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> params = new HashMap<>();
        for (Method param : annotation.annotationType().getMethods()) {
            if (param.getDeclaringClass() == annotation.annotationType()) { //this filters out built-in methods, like hashCode etc
                params.put(param.getName(), param.invoke(annotation));
            }
        }
        return params;
}