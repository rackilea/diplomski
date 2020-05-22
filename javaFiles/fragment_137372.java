// Prints 1 as both conditions are true.
System.out.println("A"=="A" ? ("B"=="B" ? "1" : "2") : "3");
// Prints 3 as first condition fails.
System.out.println("A"=="notA" ? ("B"=="B" ? "1" : "2") : "3");
// Prints 2 as second condition fails.
System.out.println("A"=="A" ? ("B"=="notB" ? "1" : "2") : "3");