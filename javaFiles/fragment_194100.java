public static int getLowestNumber(final Scanner in) {
    System.out.println(
      "How many of the lowest values should be dropped?"
    );
    if (in.hasNextInt()) {
        return in.nextInt();
    }
    return 0;
}