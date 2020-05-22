public static boolean isConsecutive(final String pinCode)
{
    int [] digits = new int [pinCode.length()];
    int [] differences = new int [pinCode.length()-1];
    int temp = 0;

    for(int i = 0; i < pinCode.length(); i++)
        digits[i] = Integer.parseInt(String.valueOf(pinCode.charAt(i)));

    for(int i = 0; i < digits.length -1; i++)
        differences[i] = Math.abs(digits[i] - digits[i+1]);

    if(differences.length != 0) {
        temp = differences[0];
        for (int i = 1; i < differences.length; i++)
            if (temp != differences[i])
                return false;
    }

    return true;
}