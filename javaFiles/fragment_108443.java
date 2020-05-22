Class<?> name = twoinstance.class;
try {
    Object c = name.newInstance();
} catch (InstantiationException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
}