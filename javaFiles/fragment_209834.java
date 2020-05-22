public <T> void save(T user) throws IllegalAccessException, InstantiationException, InvocationTargetException {
    int i = 0;
    List<Object> args = new ArrayList<>();
    args.add(0,"Example");
    T newUser = (T)user.getClass().getConstructors()[i].newInstance(args);
    // Exciting things...
}