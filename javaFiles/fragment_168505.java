for (int i = 0; i < numbers.length; i++) {
    System.out.print("Hour " + i + ":");
    if (numbers[i] == min)
        currentchar = MIN;
    else if (numbers[i] == max)
        currentchar = MAX;
    else
        currentchar = MIDDLE;
    printTimes(currentchar, numbers[i]);
    System.out.println("");
}