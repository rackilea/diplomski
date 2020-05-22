public static void main(String args[]) {
    Field[] fields = MyClass.class.getDeclaredFields();
    for(Field field : fields ){
    field.setAccessible(true);
    String name = field.getName();
    //Check if name contains small letters or the logic to check if camel-case etc
    }
}