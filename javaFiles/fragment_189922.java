public class MyAuth extends AMLoginModule {
// same code here

     @Override
        public int process(Callback[] callbacks, int state) throws LoginException {

//same code logic here 

 switch (state) {
case AUTHENTICATE:

return GET_ADDITIONAL_DATA;
//...
case GET_ADDITIONAL_DATA:
  final String additionalData = ((NameCallback) callbacks[0]).getName();
  // handle additional data
}
}

}