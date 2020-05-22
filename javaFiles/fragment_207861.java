public class Elephant{
    private String name;

    public Elephant(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "this elephant is named" + this.name;
    }
}