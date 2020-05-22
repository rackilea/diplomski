// We know that fibo.hasNext() will always return true, but
// in general you don't...
while (fibo.hasNext()) {
    int f = fibo.next();
    System.out.println("next Fibonacci number is " + f);
    if (someCondition(f)) break;
}