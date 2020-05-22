long sum = 0;
int repeats = 1000;
for (int j = 0; j < repeats; j++) {
    buffer2.position(0);
    for (int i = 0; i < values; i++)
        sum += buffer2.getInt();
}
fis.close();
long time2 = System.nanoTime() - start2;
System.out.printf("Took %.3f seconds to read %,d values%n", time2 / 1e9, repeats * values);