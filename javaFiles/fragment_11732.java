public class Pitcher {

    private String name;
    //Other data about this pitcher. These are called fields, keep them private.

    //This is a getter, use this to access data from outside the class.
    public String getName() {
        return name;
    }

    //This is a constructor, it will be called when you first create the 
    //class using the 'new' keyword.
    public Pitcher(String name) {
        this.name = name;
    }

}

public class Project3 {
    public static void main(String[] args) {
        List<Pitcher> pitchers = new ArrayList();
        pitchers.add(new Pitcher("John Doe"));
    }
}