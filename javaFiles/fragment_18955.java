public class Secured extends Security.Authenticator {

    public static final String UNAUTHENTICATED = "unauthenticated";

    public static User getLoggedInUser() {
        if (session("userId") == null)
            return null;
        return User.findById(Long.parseLong(session("userId")));
    }

    public static String getLoggedInUsername() {
        if (session("userId") == null)
            return null;
        return User.findById(Long.parseLong(session("userId"))).getUsername();
    }


    @Override
    public String getUsername(Http.Context ctx) {

        // see if user is logged in
        if (session("userId") == null)
            return null;

        // see if the session is expired
        String previousTick = session("userTime");
        if (previousTick != null && !previousTick.equals("")) {
            long previousT = Long.valueOf(previousTick);
            long currentT = new Date().getTime();
            long timeout = Long.valueOf(Play.application().configuration().getString("sessionTimeout")) * 1000 * 60;
            if ((currentT - previousT) > timeout) {
                // session expired
                session().clear();
                return null;
            } 
        }

        // update time in session
        String tickString = Long.toString(new Date().getTime());
        session("userTime", tickString);

        return User.findById(Long.parseLong(session("userId"))).getUsername();
    }
}