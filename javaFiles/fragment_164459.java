System.out.println("What hero are you playing?");
Scanner console = new Scanner(System.in);
/**you have a second scanner, but it's using the same input source. You
should only have one scanner for System.in, maybe call the variable userInput**/
Scanner value = new Scanner(System.in);
//String character = console.next(); you only take input from the user once, this needs to go into a loop.
String character; //do this instead
String[] hero = {"x1", "x2", "x3", "x4"};
while(!Arrays.asList(hero).contains(character = console.next())) {//changed to a while loop. This will keep running until the condition evaluates to false.
    System.out.println("hero not found"); //notice the '!' in the condition check. this means if next console input is NOT contained in the hero array.
}
System.out.println("hero selected: "+ character); //if we're no longer in the loop, it means we found a correct hero name.