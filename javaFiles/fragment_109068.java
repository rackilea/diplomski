for(start=0; start<numbers; start++) {
    int number;
    do {
      number = inputLine.nextInt();
    } while (number < 0);
    array[start] = number;
    sum = sum + array[start];
}