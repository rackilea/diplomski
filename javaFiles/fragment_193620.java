if (option.equals("end")) {
    System.exit(0);
}

System.out.println("First number");
first=input.nextDouble();
System.out.println("Second number");
second=input.nextDouble();

double result;

switch (option) {
    case "add":      case "+": result = first + second; break;
    case "subtract": case "-": result = first - second; break;
    case "multiply": case "*": result = first * second; break;
    case "divide":   case "/": result = first / second; break;
}

System.out.println(result);