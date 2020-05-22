// add method processParticle
public interface Particle{
    ...

    void processParticle();

}

 class Quark implements Particle {
    void processParticle() {
        Physics.processParticle(this);
    }
 }

 class Lepton extends Particle {
    void processParticle() {
        Physics.processParticle(this);
    }
 }

 public class Physics {

    public static void main(String[] args) {
        for (;;) {
           System.out.print("Enter the particle [Quark or Lepton]: ");
           Scanner in = new Scanner(System.in);      
           String input = in.next();
           Particle p;
           if (input.equals("Quark")) {
               System.out.println("Quark");
               p = new Quark();
            } else if (input.equals("Lepton")) {
               System.out.println("Lepton");
               p = new Lepton();
           } else {
              break;
           }
           p.processParticle();
        }
    }
}