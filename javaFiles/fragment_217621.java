private static void checkNumber() throws invalidNumber 
{
    if (String.valueOf(input).length() != 5) {
        throw new invalidNumber("invalid number");
    }
    else {
        System.out.println("Works!");
    }
}