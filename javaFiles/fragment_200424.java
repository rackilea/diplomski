/**
 * Class that uses Authenticator
 */

 public class X {

    // Don't use @autowire here
    public Authenticator athenticator;

    public void doSomething() {
         manuallyAutowire();
    }

    public void manuallyAutowire() {
         if(authenticator == null) {
    authenticator = ApplicationContextUtils.getApplicationContext().
                            getBean(authenticator.class);
    }
}