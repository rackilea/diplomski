import java.util.List;

public class MyPojo {

    private String value;

    private List<MyPojo> children;

    public MyPojo(String value, List<MyPojo> children) {

        this.value = value;
        this.children = children;
    }

    public String getValue1() {
        return value;
    }

    public List<MyPojo> getChildren() {
        return children;
    }

}