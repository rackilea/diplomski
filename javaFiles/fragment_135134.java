public static Result loginSubmit(){
    DynamicForm dynamicForm = Form.form().bindFromRequest();
    Logger.info("Username is: " + dynamicForm.get("username"));
    Logger.info("Password is: " + dynamicForm.get("password"));
    return ok("ok, I recived POST data. That's all...");
}