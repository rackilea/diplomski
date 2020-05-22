public static Result getValues(){
    DynamicForm requestData = form().bindFromRequest();

    String name = requestData.get("name");
    String desg = requestData.get("desg");
    // etc

    return ok("You sent: " + name + ", " + desg);
}