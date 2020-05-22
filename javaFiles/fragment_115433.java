public void showFields() throws IllegalAccessException {
    Class<?> clz = this.getClass();
    while(clz != Object.class) {
        for (Field f : clz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f + ": " + f.get(this));
        }
        clz=clz.getSuperclass();
    }
}