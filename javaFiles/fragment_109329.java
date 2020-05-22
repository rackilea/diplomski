import java.net.Authenticator;
import java.net.PasswordAuthentication;

Authenticator myAuth = new Authenticator() 
{
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication("german", "german".toCharArray());
    }
};

Authenticator.setDefault(myAuth);