@XmlRootElement
public class JavaBean {

    private String name = "";
    private String add = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "JavaBean {name=[" + name + "], add=[" + add + "]}";
    }
}