public class Animals {
    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public void changeName(String name){
        this.name= name;
    }

    public String getName(){
        return this.name;
    }

}