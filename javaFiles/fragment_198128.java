<T> T createObj(String nameclass) throws ClassNotFoundException,
        InstantiationException, IllegalAccessException {

    Class<T> clazz = (Class<T>) Class.forName(nameclass);

    // assumes the target class has a no-args Constructor
    return clazz.newInstance();
}