//Sphere.java
public class Sphere {
    private float[] position;
    private float[] mem; 
    private float[] velocity;

    public Sphere(float[] position, float[] mem,  float[] velocity) {
        this.position = position;
        this.mem = mem;
        this.velocity = velocity;
    }

    public synchronized float[] getPosition() {
        return position;
    }
    public synchronized float[] getVelocity() {
        return velocity;
    }

    public synchronized void move() {
        position[0]+=velocity[0];
        position[1]+=velocity[1];
    }
}