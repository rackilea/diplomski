Object result = DUMMY;
try {
   result = futureTask.get(5, TimeOut.SECONDS);
}
catch (TimeoutException e) {
   futureTask.cancel(true);
}