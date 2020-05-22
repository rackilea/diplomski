do
{
    // read each value in sequence, and then check to see if you should stop
    // you can/should simplify this into a function that returns the object
    // that returns null if the value should stop (requiring a capital D
    // double for the return type)

    if ( /* reason to stop */)
    {
        break;
    }

    s.setNames(name);
    s.setId(id);
    s.setMoney(money);

} while (true);

private String getString(Scanner input)
{
    String result = input.nextLine();

    // look for STOP
    if (result.equalsIgnoreCase("stop"))
    {
        result = null;
    }

    return result;
}

private Double getDouble(Scanner input)
{
    Double result = null;
    // read the line is a string looking for STOP
    String line = getString(input);

    // null if it's STOP
    if (line != null)
    {
        try
        {
            result = Double.parseDouble(line);
        }
        catch (NumberFormatException e)
        {
            // not a valid number, but not STOP either!
        }
    }

    return result;
}