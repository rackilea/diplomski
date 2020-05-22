public class Main{
    private Authenticator auth;

    //choose auth in constructor or by choosing it in a List in some GUI
    //and create an Object that extends/implements Authenticator

    public void login(String user, String password){
        if(auth.login(user, password)){
            //do whatever is needed to complete login
        }
    }

}