public int getObject(Object obj) {
    for (Field field : obj.getClass().getDeclaredFields()) {
        //field.setAccessible(true); // if you want to modify private fields
        System.out.println(field.getName()
                 + " - " + field.getType()
                 + " - " + field.get(obj));
    }
}