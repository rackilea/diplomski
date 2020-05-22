final PerlinNoiseGenerator perlin = new PerlinNoiseGenerator(new Random().nextInt());

final int size = 10000; //Size gets sqared, so it's actually 100,000,000

final float[] values = new float[size * size];
for (int x = 0; x < size; x++)
    for (int y = 0; y < size; y++) {
        final float value = perlin.noise2(x / 10f, y / 10f);
        values[x * size + y] = value;
    }
System.out.println("Calculated");

Arrays.sort(values);
System.out.println("Sorted");

final float[] steps = new float[1000];
steps[999] = 1;
for (int i = 0; i < 999; i++)
    steps[i] = values[size * size / 1000 * (i + 1)];
System.out.println("Calculated steps");

for (int i = 0; i < 10; i++) {
    System.out.println();
    for (int j = 0; j < 100; j++)
        System.out.print(steps[i * 100 + j] + "f, "); //Output usuable for array initialization
    System.out.println();
    System.out.println();
}