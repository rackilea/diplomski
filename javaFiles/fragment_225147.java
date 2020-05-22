public class Car implements Vehicle { // an implementation of Vehicle, just like Tomcat provides an implementation of HttpServletResponse

    private Person driver; // contains a person, just like the HttpServletResponse iplementation contains a PrintWriter

    public Car(Person driver) {
        this.driver = driver;
    }

    @Override
    public Person getDriver() {
        return this.driver;
    }
}