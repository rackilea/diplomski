switch (option) {
    case "add":
    case "+":
        System.out.println("First number");
        first=input.nextDouble();
        System.out.println("Second number");
        second=input.nextDouble();
        double add=first+second;
        System.out.println(add);

        break;

    case "subtract":
    case "-":
        System.out.println("First number");
        first=input.nextDouble();
        System.out.println("Second number");
        second=input.nextDouble();
        double subtract=first-second;
        System.out.println(subtract);

        break;

    case "multiply":
    case "*":
        System.out.println("First number");
        first=input.nextDouble();
        System.out.println("Second number");
        second=input.nextDouble();
        double multiply=first*second;
        System.out.println(multiply);

        break;

    case "divide":
    case "/":
        System.out.println("First number");
        first=input.nextDouble();
        System.out.println("Second number");
        second=input.nextDouble();
        double divide=first/second;
        System.out.println(divide);

        break;

    case "end":
        System.exit(0);
}