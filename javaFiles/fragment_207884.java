public class Login {

    // Interface callback here
    public interface OnLoginListener {
        void onSuccess(String username);
        void onError(String message);
    }

    // Added as a parameter here
    public void validate(String uname, String pass, OnLoginListener callback) {
        // TODO: However you did this, it should be a blocking call
        String response = tryLogin(uname, pass); 

        boolean errorCondition = false; // TODO: Implement
        if (errorCondition && callback != null) {
            callback.onError("Login failed");
            return;
        }

        if (response.equals("success") && callback != null) {
            callback.onSuccess(uname);
        }
    }

}