// (java code)
public class RepetitiveDigitsRule implements IValidationRule
{
    public String getDescription()
    {
        return "TPIN contains repetitive digits";
    }

    public boolean matches(String tpin)
    {
        char firstChar = tpin.charAt(0);
        for (int i = 1; i < tpin.length(); i++)
            if (tpin.charAt(i) != firstChar)
                return false;
        return true;
    }
}

public class StartsWithZeroRule implements IValidationRule
{
    public String getDescription()
    {
        return "TPIN starts with zero";
    }

    public boolean matches(String tpin)
    {
        if (tpin.length() < 1)
            return false;

        return tpin.charAt(0) == '0';
    }
}