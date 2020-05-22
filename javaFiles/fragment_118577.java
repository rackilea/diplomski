public static void main(String[] args) {
    Example sharedData = new Example();
    for (int i = 0; i < 1000; i++)
        sharedData.increment();
    System.out.println("Incrementer finished");
    for (int i = 0; i < 1000; i++)
        sharedData.decrement();
    System.out.println("Decrementer finished");
    System.out.println(sharedData.count);
}