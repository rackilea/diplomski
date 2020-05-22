public class LoginInteractorImpl implements LoginInteractor {

   public void login(final String username, final String password, final OnLoginFinishedListener listener) {

     mUserRepository = createClient();

     mCall = mUserRepository.doLogin(getCredentials(username,password));

     mCall.enqueue(new LoginCallback());
   }

    UserRepo createClient(){
       RetrofitHelper.createClient(UserRepo.class)
    }

    Credentials getCredentials(String username, String password){
        return Credentials.basic(username, password)
    }
}