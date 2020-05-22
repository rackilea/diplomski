Object object = new SubFoo();
Method privateFooMethod = Arrays.asList(ParentFoo.class.getDeclaredMethods())
    .stream().filter(m -> m.getName().equals("privateFooMethod")).findAny()
    .get();
privateFooMethod.setAccessible(true);
privateFooMethod.invoke(object);