public static void main(String[] args) {
    Map<Object, String> map = new HashMap<>();

    for (Field f : KeyEvent.class.getDeclaredFields()) {
        try {
            if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) {
                f.setAccessible(true);
                map.put(f.get(null), f.getName());
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
    System.out.println(map);
}