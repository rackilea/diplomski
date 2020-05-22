public class UsersController {

  public static Result updateFirstName() {

    // Only run the validation rules that need to hold when updating a user's first name
    Form<User> filledForm = Form.form(User.class, User.FirstNameStep.class).bindFromRequest();

    if (form.hasErrors()) {
      // return bad request with errors as json
    }

    // else save and return ok()
  }
}