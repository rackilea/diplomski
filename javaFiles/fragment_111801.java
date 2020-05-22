int sum = 0;
int count = 0;
for (int i = 300; i >= 200; i--) {
    if ((i % 11 == 0) ^ (i % 13) == 0) {
        System.out.printf("%-8d", i);
        count++;
        sum += i;
        if (count % 5 == 0) {
            System.out.println();
        }
    }
}
System.out.printf("Found %d multiples, with a sum of %d.%n", count, sum);