public static Result index() {
    DynamicForm bindedForm = form().bindFromRequest();
    System.out.println(bindedForm.get("myname"));
    // or...
    Logger.info(bindedForm.get("myname")); 
        // Play's Logger is nicer than System.out.println();
    return ok(index.render(null)); }
}