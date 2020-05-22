while (number != 0) {     
    System.out.print (number % 2); // prints a binary digit (i.e. 0 or 1)    
    reverse = reverse * 2 + number % 2;         
    number = number / 2;         
}
System.out.println();
System.out.println(reverse); // prints the decimal representation of the reversed number