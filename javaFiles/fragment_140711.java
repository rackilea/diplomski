for (Field field : obj.getClass().getDeclaredFields()) {
    if(field.get(obj) == desired_value)
           System.out.println("The matching field is " + field.getName());
    System.out.println(field.getName()
             + " - " + field.getType()
             + " - " + field.get(obj));

}