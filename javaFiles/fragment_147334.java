Class<?> clazz = Foo.class;
TypeVariable typeVariable = clazz.getTypeParameters()[0];
Type type = typeVariable.getBounds()[0];

System.out.println(typeVariable);
System.out.println(type);