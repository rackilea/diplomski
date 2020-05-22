public class ConfigurationAction {

    private String property = System.getProperty("jboss.server.home.dir");

    /**NOTE: MUST create a getter and setter. **/
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}