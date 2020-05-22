int cnt = 0;
for(String key: vehicles.keySet()) {
  System.out.println(key + " - " + vehicles.get(key));

  if (++cnt % 500 == 0) {
    Thread.sleep(sleepTime);  // throws InterruptedException; needs to be handled.
  }
}