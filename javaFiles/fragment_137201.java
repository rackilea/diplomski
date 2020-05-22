for (String var : myStrings) {
    Field field = MyClass.class.getDeclaredField(var);
    field.setAccessible(true);
    System.out.println(var);
    System.out.println(field.get(myObject));
    System.out.println();
}