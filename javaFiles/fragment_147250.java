public class LawSuiteEE implements ILawSuiteEE {

private InitialContext context;
private ProgrammaticLogin login;


@Override
public void connect(String address, String port) throws RemoteException {
    if(context==null) {
        try {
            System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts", "500:30000:20:"+Integer.MAX_VALUE);
            System.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts", "250:90000:100:"+Integer.MAX_VALUE);
            System.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout", "300000");
            System.setProperty("java.security.auth.login.config", new File("login.conf").getAbsolutePath());
            System.setProperty("org.omg.CORBA.ORBInitialHost", address);
            System.setProperty("org.omg.CORBA.ORBInitialPort", Integer.toString(port));
            Logger.getLogger(RemoteDatastore.class.getName()).log(Level.INFO, "Try to connect to application server at "+System.getProperty("org.omg.CORBA.ORBInitialHost")+":"+System.getProperty("org.omg.CORBA.ORBInitialPort")+" ...");            
            context = new InitialContext();
        } catch (NamingException ex) {
            throw new RemoteException(ex.getMessage());
        }
    }
}

@Override
public void disconnect() throws RemoteException {
    if(context!=null) {
        try {
            context.close();
            Logger.getLogger(LawSuiteEE.class.getName()).log(Level.INFO, "Server context successfully closed.");
        } catch (NamingException ex) {
            Logger.getLogger(LawSuiteEE.class.getName()).log(Level.SEVERE, "Couldn't close server context.");
        } finally {
            this.facades.clear();
            this.services.clear();
            this.context=null;
        }
    }
}

@Override
public boolean login(String username, char[] password) throws RemoteException {
    login = new ProgrammaticLogin();
    return login.login(username, password);
}