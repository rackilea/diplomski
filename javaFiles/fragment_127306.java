int sphereCount = 30;
    List<Sphere> spheres = new ArrayList<Sphere>();
    Random rand = new Random();
    for( int i = 0; i < sphereCount; i++) {
        spheres.add(
            new Sphere(
                new float[]{20*rand.nextFloat(), 20*rand.nextFloat()}, //position
                new float[]{20*rand.nextFloat(), 20*rand.nextFloat()}, //mem
                new float[]{2*rand.nextFloat(), 2*rand.nextFloat()} //velocity
            )
        );
    }