int sum = start;
System.out.print(start);
for (int i = start + 1; i <= end; i++) {
    System.out.print("+" + i);
    sum += i;
}
System.out.println(" = " + sum);