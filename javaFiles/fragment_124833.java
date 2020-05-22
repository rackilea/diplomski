private static void printAnswer(int numberOfItems, int dividedDifference) {

    for(int i = 1; i <= maxNumberOfItems; i++)
    {
        System.out.print(i);
    }

    System.out.println();

    System.out.print(StringUtils.repeat(" ", dividedDifference));

    for(int i = 1; i <= numberOfItems; i++)
    {
        System.out.print(i);
    }

    System.out.print(StringUtils.repeat(" ", maxNumberOfItems - numberOfItems - dividedDifference));

}