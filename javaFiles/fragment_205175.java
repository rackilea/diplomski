try {
    User user = new User();
    Method method = User.class.getDeclaredMethod("setName", String.class);
    method.setAccessible(true);
    method.invoke(user, "Some name");
    System.out.println("user.getName() = " + user.getName());
} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
    e.printStackTrace();
}