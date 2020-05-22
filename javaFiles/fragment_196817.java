import org.apache.struts2.convention.annotation.Namespace;
    ...
    @Namespace{"/persons/{param1}/{param2}");
    public class PersonActionBean exends ActionSupport {
        private String param1;
        private String param2;
        // getter and setter
    }