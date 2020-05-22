public static double sum(int numberinput) {
    if (numberinput == 0)
        return 1;
    else
        return factorial(numberinput) + sum(numberinput-1);
}