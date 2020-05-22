public static class Particles implements Iterable<Particle> {
        ArrayList<Particle> myParticles = new ArrayList<Particle>();

        public void add(Particle particle) { myParticles.add(particle); }

        public Iterator<Particle> iterator() {
            return new Iterator<Particle>() {
                Iterator<Particle> listIterator = myParticles.iterator();

                @Override
                public boolean hasNext() {
                    return listIterator.hasNext();
                }

                @Override
                public Particle next() {
                    return listIterator.next();
                }

                @Override 
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

    }