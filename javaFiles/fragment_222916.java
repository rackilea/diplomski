long startTimeMillis = System.currentTimeMillis();
int numIterations = 100000;
for (int i = 0; i < numIterations; i++) {
    double randomNumber = random.nextDouble() * 100.0;
    final String id = generateRandomId(random);
    service.submit(new CassandraReadTask(id, columnFamilyList));
}
service.shutdown();
service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
long diff = System.currentTimeMillis() - startTimeMillis;
System.out.println("Average time per iteration is " + (numIterations / diff));