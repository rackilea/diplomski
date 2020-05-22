long durationMillis = TimeUnit.MINUTES.toMillis(2);
long endTime = System.currentTimeMillis() + durationMillis;
do {
  int delaySec = ThreadLocalRandom.current().nextInt(2, 7);
  TimeUnit.SECONDS.sleep(delaySec);
  System.out.println("Hi " + delaySec);
} while (System.currentTimeMillis() < endTime);