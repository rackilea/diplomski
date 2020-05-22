public class Outer {
    private int id;
    public Outer(int id) { this.id = id;}

    public class Inner{
        void printOuterID(){
            System.out.println(id); 
        }
    }
}