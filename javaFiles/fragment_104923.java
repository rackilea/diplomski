double [] numbers = new double[entry];
for (counter = 0; counter< entry; counter++){       
    System.out.println("Please input number " + (counter +1));
    numbers[counter] = scanner.nextDouble();
    sum+= numbers[counter];
}
System.out.println("The total sum is: " + sum);
double average = sum/entry;
System.out.println("The total average is: " + average);