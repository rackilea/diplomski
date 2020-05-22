YourClassObject objectToIntrospect = new YourClassObject();
    for (Field field : objectToIntrospect.getClass().getDeclaredFields()) {
        field.setAccessible(true); // to allow the access of member attributes
        Object attribute = field.get(objectToIntrospect); 
        if (attribute == null) {
            System.out.println(field.getName() + "=" + attribute);
        }
    }