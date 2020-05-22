boolean isDone = false;
while (!isDone) {
    int hour = new DateTime().getHourOfDay();
    isDone = hour >= 20;
    if (!isDone) TimeUnit.HOURS.sleep(20 - hour);

    isDone = checkStatus();
    if (!isDone) TimeUnit.MINUTES.sleep(15);
}

System.out.println("Hello World");