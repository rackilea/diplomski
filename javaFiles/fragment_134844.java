public class MyClass {
    private List<String> stringList;
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}

//...
MyClass myClass = new MyClass();
myClass.setStringList(new ArrayList<String>());
myClass.setStringList(new LinkedList<String>());