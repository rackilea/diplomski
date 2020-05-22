if (option.equals("end")) {
    System.exit(0);
}

System.out.println("First number");
first=input.nextDouble();
System.out.println("Second number");
second=input.nextDouble();

switch (option) {
    case "add":
    case "+":
        double add=first+second;
        System.out.println(add);
        break;

    case "subtract":
    case "-":
        double subtract=first-second;
        System.out.println(subtract);
        break;

    case "multiply":
    case "*":
        double multiply=first*second;
        System.out.println(multiply);
        break;

    case "divide":
    case "/":
        double divide=first/second;
        System.out.println(divide);
        break;
}