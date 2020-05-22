public final Result submit() {
    Result result = null;

    Form<Something> boundForm = Form.form(Something.class).bindFromRequest();
    if (boundForm.hasErrors()) {
        result = badRequest(sometemplate.render(boundForm));
    } else {
        potentiallyDoSomethingWith(boundForm.get());
        result = redirect(route.Application.somewhere());
    }
    return result;
}