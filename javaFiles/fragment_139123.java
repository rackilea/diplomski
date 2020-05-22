import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.NONE)
public class Parent {

    private String parentProperty1;
    private String parentProperty2;

    public String getParentProperty1() {
        return parentProperty1;
    }

    public void setParentProperty1(String parentProperty1) {
        this.parentProperty1 = parentProperty1;
    }

    public String getParentProperty2() {
        return parentProperty2;
    }

    public void setParentProperty2(String parentProperty2) {
        this.parentProperty2 = parentProperty2;
    }

}