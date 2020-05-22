float n = 1f;
System.out.println(n);

for (int i = 0; i < 100; i++) {
    n = Math.nextUp(n);
    System.out.println(n);
}