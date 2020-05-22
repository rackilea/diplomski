for(int i = 0; i < 100; i++) { 
    particle.add(new Particle());
    timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            // change polygon data
            // ...
            Particle p = new Particle();
            p.move();
            repaint();

        }
    });
}