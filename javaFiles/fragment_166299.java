public class TestController extends Controller {

    public static Result insertUser(String user_id, String fname, String lname)
    {
        User user = new User(user_id);
        UserLegalName legal = new UserLegalName(user,fname,lname);
        user.legalName = legal;
        user.save();

        return ok(user.legalName.firstName);
    }

    public static Result getUser(String user_id)
    {
        User user = User.findByUserID(user_id);

        return ok(user.legalName.firstName);
    }
}