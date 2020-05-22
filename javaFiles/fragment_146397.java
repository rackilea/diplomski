public class Crud<T extends Model> {

    private final Model.Finder<Long, T> find;
    private final Form<T> form;

    public Crud(Model.Finder<Long, T> find, Form<T> form) {
        this.find = find;
        this.form = form;
    }

    public Result list() {
        return ok(Json.toJson(find.all()));
    }

    public Result create() {
        Form<T> createForm = form.bindFromRequest();
        if (createForm.hasErrors()) {
            return badRequest();
        } else {
            createForm.get().save();
            return ok();
        }
    }

    public Result read(Long id) {
        T t = find.byId(id);
        if (t == null) {
            return notFound();
        }
        return ok(Json.toJson(t));
    }

    // … same for update and delete
}