public class SomeClass {
    // this is local to this class only
    ArrayList<String> viewArray = new ArrayList<String>();
    public void process() {
       // i'm guessing there is some sort of processing method that is called
    }
    public ArrayList<String> getView() {
       return viewArray;
    }
}