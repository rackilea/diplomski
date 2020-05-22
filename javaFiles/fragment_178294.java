public class EntryPoint {
    private ArrayList<String> myData=new ArrayList<String>();

    public static void main( String[] args ) {
        EntryPoint ep = new EntryPoint();
        ep.init();
    }

    private void init() {
        // Populate myData perhaps?

        SomeOtherClass myClass=new SomeOtherClass();
        myClass.someMethod( this );
    }

    public List<String> getMyData() {
        return myData;
    }
}   

public class SomeOtherClass {
    public void someMethod( EntryPoint entry ) {
        List<String> data = entry.getMyData();
        // do stuff with data..!
    }
}