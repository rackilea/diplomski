for (Field field : object.getClass().getDeclaredFields()) {
   //check for the EntityMapper annotation
   if (field.getAnnotation(EntityMapper.class) != null) {
       .
       .
       .//Use more reflection to use getters and setters to create and assign values from the JSON request.
   }
}