Scanner reader = new Scanner(System.in); // Take out this from inside for loop

for (int i = 0; i < BugObj.length; i++) { // Notice we use BugObj.length instead of a number and start index at 0.
  System.out.println("Please enter the name of the bug:");
  BugObj[i] = new ABug(); // You need to initialize the instance before use it
  BugObj[i].name = reader.next();