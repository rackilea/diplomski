private static final ThreadLocal<SimpleDateFormat> df =
    new ThreadLocal<Integer>() {
         @Override protected Integer initialValue() {
             return new SimpleDateFormat("dd.MM.yyyy");
     }
 };
 public void doSomething() {
    // ...
    beans.put("df", df.get());
    // ...
}