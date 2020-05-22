for(int i = 0; i < listOfFractions.size(); i++)
{
    int num = 1 + random.nextInt(5);
    int denum = 1 + random.nextInt(5);
    Fraction fraction1 = new Fraction(num, denum); //fraction 1
    Fraction fraction2 = listOfFractions.get(i); //grab the previously created fraction
    System.out.println("Multiplying Fraction 1");
    fraction1.printFraction();
    System.out.println("By Fraction 2");
    fraction2.printFraction();
    System.out.println("Gives us the following fraction");
    fraction1.multiply(fraction2); //multiply the two fractions
    fraction1.printFraction();
}