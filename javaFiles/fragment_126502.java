private int totalobjectcount = 0;

private void count(Object o) {
    countFields(o);
    System.out.println("total object count " + totalobjectcount);
}

private void countFields(Object o) {
    totalobjectcount++;

    Class<? extends Object> c1 = o.getClass();
    countFields(o, c1);
}

private void countFields(Object o, Class<? extends Object> c1) {
    Field[] fields = c1.getDeclaredFields();
    for (Field field : fields) {
        Object oo;
        field.setAccessible(true);
        oo = field.get(o);
        countFields(oo);

    }
    countFields(o, c1.getSuperclass());
}