public class Hop {
    public Hop() {   
        System.out.println("Hop");
    }
    public static void main(String args[]) {
        Jump j = new Jump();       

    }
}
class Skip extends Hop {
    public Skip() {
        System.out.println("Skip ");
    }

}
class Jump extends Skip {
    public Jump() {
        System.out.println("Jump ");
    }
}