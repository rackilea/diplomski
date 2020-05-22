// Hideously slow program! Can you spot the object creation?
Long sum = 0L;
start = System.currentTimeMillis();
for (long i = 0; i < Integer.MAX_VALUE; i++) {
    sum += i;
}
end = System.currentTimeMillis();
System.out.println("Long sum took: " + (end - start) + " milliseconds");

long sum2 = 0L;

// reset start!!
start = System.currentTimeMillis();

for (long i = 0; i < Integer.MAX_VALUE; i++) {
    sum2 += i;
}
end = System.currentTimeMillis();
System.out.println("long sum took: " + (end - start) + " milliseconds");