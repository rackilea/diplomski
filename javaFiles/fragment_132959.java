for (Field field : fields) {
    boolean accessible = field.isAccessible();
    field.setAccessible(true);
    try {
        if ( ! Objects.equals(field.get(this), field.get(myO))) {
            return false;
        }
    }
    catch (IllegalAccessException e) {
        System.out.println(e);
    } finally {
        field.setAccessible(accessible);
    }
}