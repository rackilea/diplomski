private class SmsSenderTask implement Runnable {
     private String text;
     private List<String> phoneNumbers;

     public void run() {
         for (String number : phoneNUmbers) {
             sendSms(number, text);
         }
     }
}

ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
for (Date d : dates) {
    long millis = d.getTime() - System.currentTimeMillis();
    service.schedule(new SmsSenderTask(text, phoneNumbers), millis, TimeUnit.MILLISECONDS);
}