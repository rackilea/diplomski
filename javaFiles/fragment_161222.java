java.util.Set<Parameter<?>> params = query.getParameters();
for (Parameter p : params) {
    String paramName = p.getName();
    System.out.print(paramName + " - ");
    System.out.println(query.getParameterValue(paramName));
}