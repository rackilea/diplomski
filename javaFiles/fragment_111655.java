Field[] fields = source.getClass().getDeclaredFields();

for (Field f: fields) {
    if (properties.contains(f.getName())) {

        f.setAccessible(true);

        f.set(destination, f.get(source));
    }
}