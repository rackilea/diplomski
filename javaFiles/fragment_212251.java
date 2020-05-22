public static void babyRoot(double num , double err)
{
    testnum = 0.5 * (testnum + (targetnum / testnum));
    System.out.println("Test number equals: " + testnum);

    if ((testnum >= (Math.sqrt(targetnum) - err)) &&
        (testnum <= (Math.sqrt(targetnum) + err)))
        System.out.println("The correct square root is: " + testnum);
    else
        babyRoot(testnum);
}