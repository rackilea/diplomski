public static Result update() {
    Form<Person> personForm = Form.form(Person.class).bindFromRequest(request());
    if(personForm.hasErrors()) {
        return badRequest(person.render(personForm));
    }

    personForm.get().save();

    return ok("Saved...");
}