import java.util.Random;

public class Particle {
    // Data fields:
    private double lifetime;
    private double decay;
    private double r, g, b;
    private double xpos, ypos, zpos;
    private double xspeed, yspeed, zspeed;
    private boolean active;

    // Constructor
    public Particle() {
        r = 0.7; g = 0.7; b = 1.0;
        decay = 0.001;
        Random rand = new Random();
        lifetime = rand.nextInt(500000)/500000.0;
        xspeed = 0.0005 - rand.nextInt(100)/100000.0;
        yspeed = 0.01 - rand.nextInt(100)/100000.0;
        zspeed = 0.0005 - rand.nextInt(100)/100000.0;
        active = true; 
        // all others are 0 by default
    }
}