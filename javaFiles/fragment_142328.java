String input;
System.out.print("Enter the 4 numbers with a pound key: ");
input = keyboard.next();
while (!input.startsWith("#")) {
 System.out.print("Re-enter the 4 numbers with a pound key: ");
 input = keyboard.next();
}
// if your excution reaches here. then it means the values entered by user is starting from '#'.
String temp = input;
double value = Double.parseDouble(temp.replace("#",""));