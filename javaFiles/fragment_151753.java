System.out.print(m.getName() + "(");
Class<?>[] params = m.getParameterTypes();
for (int i = 0; i < params.length; i++) {
    if (i > 0) {
        System.out.print(", ");
    }
    System.out.print(params[i].getSimpleName());
}
System.out.println(")");