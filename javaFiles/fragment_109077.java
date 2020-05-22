public static Result edit(Long id) {
    Form<Computer> computerForm = form(Computer.class).fill(
        Computer.find.byId(id)
    );
    return ok(
        editForm.render(id, computerForm)
    );
}