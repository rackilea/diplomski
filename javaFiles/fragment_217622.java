private static void checkNumber(int number) throws invalidNumber 
    {
        if (String.valueOf(number).length() != 5) {
            throw new invalidNumber("invalid number");
        }
        else {
            System.out.println("Works!");
        }
    }