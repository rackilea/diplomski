private static FXMLExampleMVC instance;
public FXMLExampleMVC() {
           instance = this;
}
// static method to get instance of view
public static FXMLExampleMVC getInstance() {
        return instance;
}