int num = betweenMethod(10, 50);
while (num != 0) {
    System.out.printf("Number Entered: %d.%n", num);
    num = betweenMethod(num);
}
System.out.println("Good Bye");
break;