public class ImplementAuthentication {

    void authentication() {

        AuthenticationHeader authenticationHeader = new AuthenticationHeader();

        authenticationHeader.setPassword("MyPassword");
        authenticationHeader.setUserName("MyUsername");

        ObjectFactory obj = new ObjectFactory();

        obj.createAuthenticationHeader(authenticationHeader);
    }
}