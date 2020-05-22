int sum = 0;
int a = 1;
System.out.printf("              a=%-11d   sum=%d%n", a, sum);
for (int j = 1; j < 21; j++) {
    for(int i=1;i<j+1;i++) {
        a = a * i;
        sum += a;
        System.out.printf("j=%-2d   i=%-2d   a=%-11d   sum=%d%n", j, i, a, sum);
    }
}
System.out.println("sum=" + sum);