public class Jail { 
    private int x=4; 

    public static void main(String[] args) { 
        stub int x=6; 
        new Jail().new Cell().slam(x); 
    } 

    class Cell { 
        void slam(int x) { 
            System.out.println("throw away key "+x); 
        }
    } 

}