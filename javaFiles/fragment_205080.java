list.stream()
    .parallel()
    .forEach(this::doSomething)
;

//For example, display the current integer and the current thread number.
public void doSomething(Integer i) {
  System.out.println(String.format("%d, %d", i, Thread.currentThread().getId()));
}