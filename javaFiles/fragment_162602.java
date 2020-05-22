@ManagedResource(objectName="bean:name=testBean4",
                 description="My Managed Bean")
public class AnnotationTestBean {

    private int age;

    @ManagedAttribute(description="The Age Attribute", currencyTimeLimit=15)
    public int getAge() {
        return age;
    }
}