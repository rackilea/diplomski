public class PasswordCallbackHandler implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for(Callback callBack:callbacks){
            if(callBack instanceof WSPasswordCallback){
                ((WSPasswordCallback)callBack).setPassword("password");
            }
        }
    }
}