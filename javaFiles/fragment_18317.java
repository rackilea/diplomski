Random random = new Random(1);
long start = System.nanoTime();
int values = 1000000;
for (int i = 0; i < values; i++)
    random.nextInt();
long time = System.nanoTime() - start;
System.out.printf("Took %.3f seconds to generate %,d values%n",
                  time / 1e9, values);