Field field = ... // get fields
Annotation annotation = field.getAnnotation(Input.class);

if(annotation instanceof Input){
    Input inputAnnotation = (Input) annotation;
    String name = inputAnnotation.name();
    if(name == null) { // if the name not defined, default it to field name
        name = field.getName();
    }
    System.out.println("name: " + name); //use the name
}