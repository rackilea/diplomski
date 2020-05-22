OpenSimplexNoise noise = new OpenSimplexNoise(); //May provide seed as argument to generate different patterns.
for (int y = 0; y < 256; y++) {
    for (int x = 0; x < 256; x++) {
        double value = noise.eval(x / 32.0, y / 32.0, 0.5); //2D slice of 3D at z=0.5
        //Now do whatever you need to do with the value.
    }
}