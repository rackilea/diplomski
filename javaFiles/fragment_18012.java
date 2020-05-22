long start = System.nanoTime();

//this will be converted to a constant of 45 at compile time
int total = (0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);
long end = System.nanoTime();

System.out.printf("The sum is %d\n", total);
System.out.println("Time: " + (end - start));

start = System.nanoTime();
int a0=0,
    a1=1,
    a2=2,
    a3=3,
    a4=4,
    a5=5,
    a6=6,
    a7=7,
    a8=8,
    a9=9;
total = a0;
total += a1;
total += a2;
total += a3;
total += a4;
total += a5;
total += a6;
total += a7;
total += a8;
total += a9;
end = System.nanoTime();

System.out.printf("The sum is %d\n", total);
System.out.println("Time: " + (end - start));