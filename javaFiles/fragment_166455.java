int count = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE,
       sum = 0, even = 0, odd = 0;
 while (scanner.hasNextInt()) {
    int number = scanner.nextInt();
    if (number < min)
        min = number;
    if (number > max)
        max = number;
    if (number % 2 == 0)
        even++;
    else
        odd++;
    sum+= number;
    count++;
 }
 double average = sum * 1.0 / count;