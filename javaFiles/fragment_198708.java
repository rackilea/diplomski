public class DifferentClass {

    private MainClass mc = new MainClass();

    public void randomMethod() {
        //assuming getRandomHashMap is the getter of randomHashMap attribute (and non static)
        System.out.println("randomHashMap is " + (mc.getRandomHashMap() == null));
    }
}

public class MainClass {
    private HashMap<String,Nation> randomHashMap = new HashMap<String,Nation>();
    DifferentClass d = new DifferentClass(this);

    public HashMap<String,Nation> getRandomHashMap() {
        return this.randomHashMap;
    }
} //with getters/setters