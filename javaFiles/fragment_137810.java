while (true) {
    ...
    System.out.print("Enter the first X coordinate: ");
    String x1 = input.nextLine();
    if (timeToExit(x1)) break;
    double x1_d = Double.parseDouble(x1);
    ...
}