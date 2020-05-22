long start = System.nanoTime();
for (int i = 0; i < reps; i++) {
    codeToTest();
}
long end = System.nanoTime();
System.out.println((end - start) / reps + " ns");