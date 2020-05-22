try {
    final Field i = first.getClass().getDeclaredField("i");
    i.setAccessible(true);
    System.out.println(i.getInt(first));
} catch (NoSuchFieldException | IllegalAccessException e) {
    e.printStackTrace();
}