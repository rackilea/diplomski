public boolean isAnInt(String number)
{
    try {
        Integer.parseInt(number);
    } catch(NumberFormatException ex) {
        return false;
    }
    return true;
}

public boolean isFloat(String number)
{
    try {
        Float.parseFloat(number);
    } catch(NumberFormatException ex) {
        return false;
    }
    return true;
}