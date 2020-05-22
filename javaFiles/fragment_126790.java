Scanner sc = new Scanner(System.in);
String input = sc.nextLine(); //get input from user

char firstLetter = input.charAt(0); //get the first letter
input = input.substring(1); //remove the first letter from the input string
input = input + firstLetter + "ay"; //add first letter and "ay" to end of input string