Test t= new Test();
for (Field field : t.getClass().getDeclaredFields()) {
    if (field.getType().equals(String.class) && !((String)field.get(t)).isEmpty()) {
        System.out.println(field.get(t));
    }
}