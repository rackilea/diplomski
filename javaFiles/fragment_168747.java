public class FinanceManager {
    private CustomObject instanceOfCustomObject;
    public String Compname;

    public FinanceManager(String Compname){
        this.Compname = Compname;
        this.instanceOfCustomObject = new CustomObject();
    }

    public CustomObject getInstanceOfCustomObject(){
        return this.instanceOfCustomObject
        // I need to return a custom object which return too many object as single object.
    }

}