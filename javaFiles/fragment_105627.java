public static BigDecimal pow(BigDecimal x, BigDecimal y)
{
    String yString = y.toPlainString();
    if(y.compareTo(BigDecimal.valueOf(999999999)) == 1) // In smaller ^values (like 1000000) in each algorithm we must waiting infinitely long so this is only 'protection' from exceptions.
    {
        System.out.println("Too big value for exponentiation");
        return new BigDecimal("0");
    }
    else if(x.compareTo(BigDecimal.valueOf(0)) == 0)
    {
        return new BigDecimal("0");
    }
    int yStringCommaIndex = yString.indexOf(".");

    if(yStringCommaIndex == -1)
    {
        String xString = x.toPlainString(), xString2;
        int precision = xString.indexOf(".")+1;
        if(precision == 0)
        {
            if(xString.length() > 53)
            {
                System.out.println("Too long value of integer number. Max is 53.");
                return new BigDecimal("0");
            }
            precision = xString.length()+1;
        }
        else if(precision > 54)
        {
            System.out.println("Too long value of integer number. Max is 53.");
            return new BigDecimal("0");
        }

        BigDecimal result = x.pow(Integer.parseInt(yString)).setScale(32, RoundingMode.HALF_UP);
        xString2 = result.toPlainString();
        precision = xString2.indexOf(".");
        if(precision > 32)
        {
            precision = 32;
        }
        else if(precision == -1 || precision == 1 && xString2.charAt(0) == '0')
        {
            precision = 0;
        }
        result = result.setScale(32-precision, RoundingMode.HALF_UP);


        String regExp = "9{16}", resultString = result.toPlainString();
        int commaIndex = resultString.indexOf(".");
        if(commaIndex == -1)
        {
            return result;
        }
        String result2 = resultString.substring(0, commaIndex);
        resultString = resultString.substring(commaIndex+1);
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(resultString);
        boolean hasMatch = matcher.find();
        if(hasMatch == true)
        {
            result2 += "."+resultString.substring(0, matcher.start());
            if(result2.endsWith("."))
            {
                result2 = result2.substring(0, commaIndex);
                return new BigDecimal(result2).add(BigDecimal.valueOf(1));
            }
            result2 += "9";
            return new BigDecimal(result2).setScale((result2.length()-1)-(commaIndex+1), RoundingMode.HALF_UP);
        }

        regExp = "0{16}|0+$";
        resultString = result.toPlainString();
        commaIndex = resultString.indexOf(".");
        if(commaIndex == -1)
        {
            return result;
        }
        result2 = resultString.substring(0, commaIndex+1);
        resultString = resultString.substring(commaIndex+1);
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(resultString);
        hasMatch = matcher.find();
        if(hasMatch == true)
        {
            result2 += resultString.substring(0, matcher.start());
            if(result2.endsWith("."))
            {
                result2 = result2.substring(0, commaIndex);
            }
            return new BigDecimal(result2);
        }
        return result;
    }
    else
    {
        if(x.compareTo(BigDecimal.valueOf(0)) == -1)
        {
            System.out.println("Wrong input values");
            return new BigDecimal("0");
        }

        BigDecimal x1 = x.pow(Integer.parseInt(yString.substring(0, yStringCommaIndex))); // Integer value

        String xString = x.toPlainString(), xString2;
        int precision = xString.indexOf(".")+1;
        if(precision == 0)
        {
            if(xString.length() > 53)
            {
                System.out.println("Too long value of integer number. Max is 53.");
                return new BigDecimal("0");
            }
            precision = xString.length()+1;
        }
        else if(precision > 54)
        {
            System.out.println("Too long value of integer number. Max is 53.");
            return new BigDecimal("0");
        }
        BigDecimal val = BigFunctions.ln(x, 33).setScale(32, RoundingMode.HALF_UP).multiply(new BigDecimal("0"+yString.substring(yStringCommaIndex)));
        BigDecimal x2 = BigFunctions.exp(val, 33).setScale(32, RoundingMode.HALF_UP); // Decimal value

        BigDecimal result = x1.multiply(x2).setScale(32, RoundingMode.HALF_UP);

        xString2 = result.toPlainString();
        precision = xString2.indexOf(".");
        if(precision > 32)
        {
            precision = 32;
        }
        else if(precision == -1 || precision == 1 && xString2.charAt(0) == '0')
        {
            precision = 0;
        }
        result = result.setScale(32-precision, RoundingMode.HALF_UP);

        String regExp = "9{16}", resultString = result.toPlainString();
        int commaIndex = resultString.indexOf(".");
        if(commaIndex == -1)
        {
            return result;
        }
        String result2 = resultString.substring(0, commaIndex);
        resultString = resultString.substring(commaIndex+1);
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(resultString);
        boolean hasMatch = matcher.find();
        if(hasMatch == true)
        {
            result2 += "."+resultString.substring(0, matcher.start());
            if(result2.endsWith("."))
            {
                result2 = result2.substring(0, commaIndex);
                return new BigDecimal(result2).add(BigDecimal.valueOf(1));
            }
            result2 += "9";
            return new BigDecimal(result2).setScale((result2.length()-1)-(commaIndex+1), RoundingMode.HALF_UP);
        }

        regExp = "0{16}|0+$";
        resultString = result.toPlainString();
        commaIndex = resultString.indexOf(".");
        if(commaIndex == -1)
        {
            return result;
        }
        result2 = resultString.substring(0, commaIndex+1);
        resultString = resultString.substring(commaIndex+1);
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(resultString);
        hasMatch = matcher.find();
        if(hasMatch == true)
        {
            result2 += resultString.substring(0, matcher.start());
            if(result2.endsWith("."))
            {
                result2 = result2.substring(0, commaIndex);
            }
            return new BigDecimal(result2);
        }
        return result;
    }
}