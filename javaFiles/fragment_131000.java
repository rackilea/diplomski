int sum = 0;
int count = 0;
while (count<20) {
    System.out.println("Enter number: ");
    int numb = Numb.nextInt();
    sum = sum+numb;
    count++;
}
System.out.println("sum is "+sum);