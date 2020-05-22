private static final Pattern DIGITS = "\\d+";

public boolean inputOK(String input)
{
    Matcher m = DIGITS.matcher(input);

    int len;

    while (m.find()) {
        len = m.group().length();
        if (len == 9 || len == 16)
            return false;
    }

    return true;
}