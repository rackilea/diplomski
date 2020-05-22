// ...
String operator;
// ...
operator = scanner.nextLine()
// ...

switch (operator) {
    case "||":
        System.out.print(Threshold + "<" + min + "||" + Threshold + ">" + max);
        break;

    case "&&":
        System.out.print(Threshold + "<" + min + "&&" + Threshold + ">" + max);
        break;

    default:
        System.out.println("Invalid operator!");
        break;
}