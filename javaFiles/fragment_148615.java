Scanner scan = new Scanner(System.in);
System.out.println("enter your operation");
String input = scan.next();
String function = "[+\\-*/]+"; //this

String[] token = input.split(function);//and this

double num1 = Double.parseDouble(token[0]);

double num2 = Double.parseDouble(token[1]);

double answer;
String operator = input.toCharArray()[token[0].length()]+"";
if (operator.matches(function) && (token[0]+token[1]+operator).length()==input.length()) {

    System.out.println("Operation is " + operator+ ", numbers are " + token[0] + " and " + token[1]);
} else {

    System.out.println("Your entry of " + input + " is invalid");
}