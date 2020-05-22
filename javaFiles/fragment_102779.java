private final ThreadLocal<Integer> int = new ThreadLocal<>();

// to read
Integer i = int.get();

// to write
int.set(i);