long num = 9;
int shift = 2

System.out.println(Long.toBinaryString(num));
long num1 = num >> shift;
System.out.println(Long.toBinaryString(num1));
long num2 = num & ( (1<<shift) - 1);
System.out.println(Long.toBinaryString(num2));