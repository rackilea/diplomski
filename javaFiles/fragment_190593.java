protected <T extends Fruit> T cut(T fruit) {
    try {
        return (T)fruit.getClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
        // throw some exception or return an alternative instance or null
    }
}