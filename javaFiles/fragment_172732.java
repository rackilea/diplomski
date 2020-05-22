static void upd(Integer val) {
    try {
        Field declaredField = val.getClass().getDeclaredField("value");
        declaredField.setAccessible(true);
        declaredField.set(val, 42);
    } catch (Exception e) {
    }
}