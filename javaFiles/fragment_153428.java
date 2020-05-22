//This should probably be MemStorage. In Java classes start with a capital letter.
//It should also probably be public.
class memStorage {  
  float storedNum1, storedNum2;

  //constructor
  //This isn't a constructor. This is a method. It would be a constructor if it matched the name 
  //of the class AND didn't return a type of "void"
  void Memory(float num1, float num2){
    storedNum1 = num1;
    storedNum2 = num2;
  }

  //Store numbers and call them when needed
  //Store the first number
  void mem1(float num1){
    num1 = number; // The value of number is undeclared. This is the syntax error you ran into.
    // Also note that you didn't store in storedNum1.
    println("number 1 has been stored");
  }

  //Store the second number
  void mem2(float num2){
    num2 = number; // The value of number is undeclared. This is the syntax error you ran into.
    // Also note that you didn't store in storedNum2.
    println("number 2 has been stored");
  }

}

// This method isn't within the body of any class. Methods always belong inside of a class.
// The way you write this method, it looks like it should be the main method of another class
// You are using to hand test the MemStorage class
void processNumber(char number){
  //Instantiate memory storage class and execute method
  memStorage storedNum1 = new memStorage();
  storedNum1.mem1();
  //print keypressed numbers
  println(storedNum1); //This method doesn't exist. You probably mean System.out.println()
  // Furthermore, you didn't override toString(), so it wouldn't print anything meaningful.
}