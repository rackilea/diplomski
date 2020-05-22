public static void yourControllerMethod() {
    ... // your validation logic

    if (validation.hasErrors()) {
       response.status = 400;
       renderJSON(validation.errors);
    }
}