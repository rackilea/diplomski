public generalMethod(Object myObj) {
    Field[] fields = myObj.getClass().getFields();
    for(Field field : fields) {
        String fieldName = field.getName();
        // I want to access that field how can i tell myObj.fielName ?

        Class c = field.getType();
        if (c instanceOf Integer) {
            Integer value = field.getInt (myObj);
        }

        // or

        Object value = field.get (myObj); 

    }
}