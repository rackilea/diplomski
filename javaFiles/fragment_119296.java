void main() throws Exception {
    List<Parent> list = new ArrayList<>();
    list.add(new Parent());
    list.add(new Child());
    for (Parent p : list) {
        Class<?>[] interfaces = p.getClass().getInterfaces();
        for (Class<?> i : interfaces) {
            Method firstMethod = i.getMethods()[0];
            firstMethod.invoke(p, new Object[0]);
        }
    }
}