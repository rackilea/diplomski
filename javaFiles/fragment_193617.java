private double readRange(Scanner input, int cityNo) {
    System.out.print("Enter maximum cell phone connectivity " +
                     "distance for city " + i + ": ");
    return input.nextDouble();
}

...
double inputRangeCity1 = readRange(user_input, 1);
double inputRangeCity2 = readRange(user_input, 2);
double inputRangeCity3 = readRange(user_input, 3);
double inputRangeCity4 = readRange(user_input, 4);