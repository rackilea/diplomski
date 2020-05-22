public class Model extends ArrayList<Particle> { 

  public Model(int N) {
      for (int i = 0; i < N; i++) {
          Particle newParticle = new Particle();
          this.add(newParticle);
      }
  }
}

public static void main(String[] args){
    Model x1 = new Model(200);
    Particle p1 = x1.get(0);                           (**)
    double d = p1.x;
    String s = String.valueOf(d);
    System.out.println(s);
}