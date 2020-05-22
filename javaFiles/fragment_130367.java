public class MainClass  {
    private CustomObject customObject = new CustomObject();  // a default one if none is provided

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }

    public void makeCall() {
        this.customObject.testMethod();
    }
}