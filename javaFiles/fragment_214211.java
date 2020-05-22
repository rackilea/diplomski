public class Bar implements Serializable {
    public List<FooJsonSimplifiedSerializationWrapper> fooList;

    public List<FooJsonSimplifiedSerializationWrapper> getFooList() {
        return fooList;
    }

    public void setFooList(List<FooJsonSimplifiedSerializationWrapper> fooList) {
        this.fooList = fooList;
    }
}