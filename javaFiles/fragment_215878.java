import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Person {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String version;

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object,);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    or

    /*
     * equal() method with exclude fields.
     * it will neglect id and version fields.
     * 
     * */
    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, "id", "version");
    }
}