public class Physics {
    public static void processParticle( Quark q ) {
        System.out.println("Quark:[" + q.getFlavors() + "]");
    }

    public static void processParticle( Lepton l ) {
        System.out.println("Lepton:[" + l.getTypes() + "]");
    }

    public static void main(String[] args) {
    boolean done = false;

    while (!done) {
       System.out.print("Enter the particle [Quark or Lepton]: ");
       Scanner in = new Scanner(System.in);      
       String input = in.next();

       if (input.equals("Quark")) {
           System.out.println("Quark");
           Quark q = new Quark();
           processParticle(q);
        } else if (input.equals("Lepton")) {
           System.out.println("Lepton");
           Lepton l = new Lepton();
           processParticle(q);
       } else {
           done = true;
    }
}