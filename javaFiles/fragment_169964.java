public class MyComplexArray {

    private List<MyComplexElement> myComplexElements = new ArrayList<>();

    public MyComplexArray() {
    }

    public void addMyComplexElement(MyComplexElement myComplexElement) {
        myComplexElements.add(myComplexElement);
    }
}

public class MyComplexElement {

    private String key;
    private String value;

    public MyComplexElement() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}