for(Field field: fieldList){            
    try {

        // Will return field value of object type, you need to cast it to the required type. For identifying the object type you can use 'instanceof' keyword.            
        Object object = myClass.getDeclaredField(field.getName()).get(myClassFromDB);

        System.out.println("object :: "+object);

        if(object instanceof String){
            System.out.println("val :: "+(String)object);
        } // Similarily you can do it for other types.

    } catch (IllegalArgumentException ex) {
        System.out.println("IllegalArgumentException :: "+ex.getMessage());
    } catch (IllegalAccessException ex) {
        System.out.println("IllegalAccessException :: "+ex.getMessage());
    }
}