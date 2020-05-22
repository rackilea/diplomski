@XmlRootElement(name="myObjects")
public class MyObjects {
    protected List<MyObject> myObject;

    public MyObjects(){
        setMyObject(new ArrayList<MyObject>());
    }

    public List<MyObject> getMyObject() {
        return this.myObject;
    }

    @XmlElement(name="myObject")
    public void setMyObject(List<MyObject> myObject) {
        this.myObject = myObject;
    }
}