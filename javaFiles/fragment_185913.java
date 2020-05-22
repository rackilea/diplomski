public class Particle {
        // Particle code
    }

    public class Particles implements Iterable<Particle> {
        ArrayList<Particle> myParticles = new ArrayList<Particle>();

        public void add(Particle particle) { myParticles.add(particle); }

        public Iterator<Particle> iterator() {
            return myParticles.iterator();
        }

        // more code on particles
    }

    void bla() {
        Particles particles = new Particles();
        particles.add(new Particle());
        particles.add(new Particle());

        for (Particle particle : particles) {
            System.out.println("P="+particle);
        }
    }