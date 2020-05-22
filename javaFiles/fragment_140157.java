package my.package;

public class SetupDatabase implements PersistenceUnitPostProcessor {

    private String username;
    private String password;
    private String dbserver;

    public void SetupDatabase(){
        //do stuff to obtain needed information
    }

    public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
        pui.getProperties().setProperty("hibernate.connection.username", username );
        pui.getProperties().setProperty("hibernate.connection.password", password);
        pui.getProperties().setProperty("hibernate.connection.url", dbserver ); 
    }

}