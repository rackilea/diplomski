switch (operation) {
    case "divide":
        double result = (double) first / second;
        string = Double.toString(result);
        break;
    case "multiply":
        double result = (double) first * second;
        string = Double.toString(result);
        break;
    case "substract":
        double result = (double) first - second;
        string = Double.toString(result);
        break;
    case "add":
        double result = (double) first + second;
        string = Double.toString(result);
        break;
}