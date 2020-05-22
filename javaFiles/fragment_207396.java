int n = input.nextInt();
double sum = 0d;
double product = 0d;

for (int i=0; i < n; i++) {
    double randomNumber = Math.random();
    sum += randomNumber;
    product = i == 0 ? randomNumber : product*randomNumber;
}

System.out.println("sum = " + sum);
System.out.println("product = " + product);