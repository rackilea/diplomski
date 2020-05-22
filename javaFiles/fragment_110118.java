private static String intToHex(int n)
{
    return String.valueOf(new char[] { hexOrder[n/16], hexOrder[n%16] });
}

public static String base64ToHexVer2(String base64) throws Exception
{
    StringBuilder hex = new StringBuilder(base64.length()*3/4); //capacity could be 3/4 of base64 string length
    if (base64.length() % 4 != 0 || base64.contains("[^a-zA-Z0-9\\+/]"))
    {
        throw new Exception("InputNotBase64");
    }
    else
    {
        for (int i = 0; i < base64.length(); i += 4)
        {
            int n0 = base64ToInt[base64.charAt(i)];
            int n1 = base64ToInt[base64.charAt(i+1)];
            int n2 = base64ToInt[base64.charAt(i+2)];
            int n3 = base64ToInt[base64.charAt(i+3)];
            // in descriptions I treat all 64 base chars as 6 bit
            // all 6 bites from 0 and 1st 2 from 1st (00000011 ........ ........)
            hex.append(intToHex(n0*4 + n1/16));
            // last 4 bites from 1st and first 4 from 2nd (........ 11112222 ........)
            hex.append(intToHex((n1%16)*16 + n2/4));
            // last 2 bites from 2nd and all from 3rd (........ ........ 22333333)
            hex.append(intToHex((n2%4)*64 + n3));
        }
    }
    return hex.toString();
}